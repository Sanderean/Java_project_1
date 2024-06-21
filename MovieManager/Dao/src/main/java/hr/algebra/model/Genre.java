/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author andru
 */
@XmlAccessorType(XmlAccessType.FIELD)
public final class Genre implements Comparable<Genre>{
    private int id;
    String name;

    public Genre(String name) {
        setName(name);
    }

    public Genre(int id, String name) {
        this(name);
        setId(id);
    }

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.name);
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
        final Genre other = (Genre) obj;
        return Objects.equals(this.name, other.name);
    }



    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Genre o) {
        return name.compareTo(o.name);
    }
}
