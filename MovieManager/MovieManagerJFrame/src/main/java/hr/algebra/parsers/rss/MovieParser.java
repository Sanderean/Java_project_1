/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.parsers.rss;

import hr.algebra.factory.ParserFactory;
import hr.algebra.factory.UrlConnectionFactory;
import hr.algebra.model.ParsedData;
import hr.algebra.utilities.FileUtils;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
/**
 *
 * @author andru
 */
public class MovieParser {

    private static final String RSS_URL = "https://www.blitz-cinestar-bh.ba/rss.aspx?id=2682";
    private static final String ATTRIBUTE_URL = "url";

    public static List<ParsedData> parse() throws IOException, XMLStreamException {
        List<ParsedData> parsedDatas = new ArrayList<>();
        HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(RSS_URL);
        try (InputStream is = con.getInputStream()) { // stream will close the connection
            XMLEventReader reader = ParserFactory.createStaxParser(is);

            Optional<TagType> tagType = Optional.empty();
            ParsedData parsedData = null;
            StartElement startElement = null;
            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT -> {
                        startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        tagType = TagType.from(qName);
                        if (tagType.isPresent() && tagType.get().equals(TagType.ITEM)) {
                            parsedData = new ParsedData();
                            parsedDatas.add(parsedData);
                        }
                    }
                    case XMLStreamConstants.CHARACTERS -> {
                        if (tagType.isPresent() && parsedData != null) {
                            Characters characters = event.asCharacters();
                            String data = characters.getData().trim();
                            switch (tagType.get()) {
                                case TITLE -> {
                                    if (!data.isBlank()) {
                                        parsedData.setTitle(data);
                                    }
                                }
                                case LINK -> {
                                    if (!data.isBlank()) {
                                        parsedData.setTrailerURL(data);
                                    }
                                }
                                case DESCRIPTION -> {
                                    if (!data.isBlank()) {
                                        String cleanDescription = Jsoup.clean(data, Safelist.none());
                                        parsedData.setDescription(cleanDescription);
                                    }
                                }
                                case DIR -> {
                                    if (!data.isBlank()) {
                                        parsedData.setDir(data);
                                    }
                                }
                                case ACTORS -> {
                                    if (!data.isBlank()) {
                                        parsedData.setActors(data);
                                    }
                                }
                                case DURATION -> {
                                    if (!data.isBlank()) {
                                        parsedData.setDuration(Integer.parseInt(data));
                                    }
                                }
                                case YEAR -> {
                                    if (!data.isBlank()) {
                                        parsedData.setYear(Integer.parseInt(data));
                                    }
                                }
                                case GENRE -> {
                                    if (!data.isBlank()) {
                                        parsedData.setGenre(data);
                                    }
                                }
                                case PUB_DATE -> {
                                    if (!data.isBlank()) {
                                        LocalDateTime publishedDate = LocalDateTime.parse(data, DateTimeFormatter.RFC_1123_DATE_TIME);
                                        if (publishedDate != null) {
                                            parsedData.setPubDate(publishedDate);
                                        }

                                    }
                                }
                                case POSTER_URL -> {
                                    if (!data.isBlank()) {
                                        parsedData.setPosterURL(data);
                                    }
                                }

                            }
                        }
                    }
                }
            }

        }
        return parsedDatas;

    }

    private enum TagType {

        ITEM("item"),
        TITLE("title"),
        LINK("link"),
        DESCRIPTION("description"),
        DIR("redatelj"),
        ACTORS("glumci"),
        DURATION("trajanje"),
        YEAR("godina"),
        GENRE("zanr"),
        POSTER_URL("plakat"),
        PUB_DATE("pubDate");
        

        private final String name;

        private TagType(String name) {
            this.name = name;
        }

        private static Optional<TagType> from(String name) {
            for (TagType value : values()) {
                if (value.name.equals(name)) {
                    return Optional.of(value);
                }
            }
            return Optional.empty();
        }
    }

}
