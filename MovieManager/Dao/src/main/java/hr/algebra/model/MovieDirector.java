/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author andru
 */
public final class MovieDirector {

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }

    public MovieDirector(int movieID, int directorID) {
        setMovieID(movieID);
        setDirectorID(directorID);
    }
    private int movieID;
    private int directorID;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.movieID;
        hash = 89 * hash + this.directorID;
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
        final MovieDirector other = (MovieDirector) obj;
        if (this.movieID != other.movieID) {
            return false;
        }
        return this.directorID == other.directorID;
    }
    
    
}
