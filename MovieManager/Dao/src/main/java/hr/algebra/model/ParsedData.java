/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author andru
 */
public class ParsedData implements Comparable<ParsedData>{
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private String title;
    private LocalDateTime pubDate;
    private String description;

    public ParsedData() {
    }

   @Override
    public int compareTo(ParsedData other) {
        if (this.title == null) {
            return (other.title == null) ? 0 : -1;
        }
        if (other.title == null) {
            return 1;
        }
        return this.title.compareTo(other.title);
    }

    // Override equals and hashCode based on the title if necessary
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ParsedData that = (ParsedData) obj;
        return title != null && title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
    
    private Integer duration;
    private Integer year;
    private String posterURL;
    private String trailerURL;
    private String dir;
    private String actors;
    private String genre;

    public ParsedData(String title, LocalDateTime pubDate, String description, Integer duration, Integer year, String posterURL, String trailerURL, String dir, String actors, String genre) {
        this.title = title;
        this.pubDate = pubDate;
        this.description = description;
        this.duration = duration;
        this.year = year;
        this.posterURL = posterURL;
        this.trailerURL = trailerURL;
        this.dir = dir;
        this.actors = actors;
        this.genre = genre;
    }

    public static DateTimeFormatter getDATE_FORMATTER() {
        return DATE_FORMATTER;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getYear() {
        return year;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public String getDir() {
        return dir;
    }

    public String getActors() {
        return actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
