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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andru
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieArchive {
    @XmlElementWrapper
    @XmlElement(name = "movieXML")
        private List <MovieXML> movieXMLs;

    public MovieArchive(List<MovieXML> movieXMLs) {
        this.movieXMLs = movieXMLs;
    }

    public MovieArchive() {
    }
        
        
}
