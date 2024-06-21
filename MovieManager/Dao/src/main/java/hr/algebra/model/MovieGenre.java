/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author andru
 */
public final class MovieGenre {

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public MovieGenre(int movieID, int genreID) {
        setMovieID(movieID);
        setGenreID(genreID);
    }
    private int movieID;
    private int genreID;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.movieID;
        hash = 89 * hash + this.genreID;
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
        final MovieGenre other = (MovieGenre) obj;
        if (this.movieID != other.movieID) {
            return false;
        }
        return this.genreID == other.genreID;
    }
    
    
}
