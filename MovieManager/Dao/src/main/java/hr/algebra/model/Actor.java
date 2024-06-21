/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author andru
 */
@XmlAccessorType(XmlAccessType.FIELD)
public final class Actor extends Person implements Comparable<Actor>{
    public Actor(int id, String name) {
        super(id, name);
    }

    public Actor(String name) {
        super(name);
    }

    public Actor() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Actor o) {
        return name.compareTo(o.name);
    }
}
