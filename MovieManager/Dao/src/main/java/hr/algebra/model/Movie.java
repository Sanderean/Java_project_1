/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author andru
 */
@XmlAccessorType(XmlAccessType.FIELD)
public final class Movie {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @XmlAttribute
    private int id;
    private String title;
    private LocalDateTime pubDate;
    private String description;
    private Integer duration;
    private Integer year;
    private String posterURL;
    private String trailerURL;
    
    public Movie(String title, LocalDateTime pubDate, String description, Integer duration, Integer year, String posterURL, String trailerURL) {
        setTitle(title);
        setPubDate(pubDate);
        setDescription(description);
        setDuration(duration);
        setYear(year);
        setPosterURL(posterURL);
        setTrailerURL(trailerURL);
    }

    public Movie(int id, String title, LocalDateTime pubDate, String description, Integer duration, Integer year, String posterURL, String trailerURL) {
        this(title, pubDate, description, duration, year, posterURL, trailerURL);
        setId(id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        return Objects.equals(this.title, other.title);
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    @Override
    public String toString() {
        return id + " - " + title;
    }
}
