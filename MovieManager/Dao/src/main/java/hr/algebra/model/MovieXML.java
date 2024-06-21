/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author andru
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieXML {
    private Movie movie;

    public MovieXML(Movie movie, List<Actor> actors, List<Director> directors, List<Genre> genres) {
        this.movie = movie;
        this.actors = actors;
        this.directors = directors;
        this.genres = genres;
    }
    
    @XmlElementWrapper
    @XmlElement(name = "actor")
    private List<Actor> actors;
    @XmlElementWrapper
    @XmlElement(name = "director")
    private List<Director> directors;
    @XmlElementWrapper
    @XmlElement(name = "genre")
    private List<Genre> genres;

    
    
}
