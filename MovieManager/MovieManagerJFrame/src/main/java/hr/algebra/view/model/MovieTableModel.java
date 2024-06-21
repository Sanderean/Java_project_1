/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import hr.algebra.model.Movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andru
 */
public class MovieTableModel extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES = {
        "Id", 
        "Title", 
        "Publish date", 
        "Description", 
        "Duration",
        "Year",
        "Poster URL",
        "Trailer URL"};
    
    private List<Movie> movies;

    public MovieTableModel(List<Movie> movies) {
        this.movies = movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
        }
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return movies.get(rowIndex).getId();
            }
            case 1 -> {
                return movies.get(rowIndex).getTitle();
            }
            case 2 -> {
                return movies.get(rowIndex).getPubDate().format(Movie.DATE_FORMATTER);
            }
            case 3 -> {
                return movies.get(rowIndex).getDescription();
            }
            case 4 -> {
                return movies.get(rowIndex).getDuration();
            }
            case 5 -> {
                return movies.get(rowIndex).getYear();
            }
            case 6 -> {
                return movies.get(rowIndex).getPosterURL();
            }
            case 7 -> {
                return movies.get(rowIndex).getTrailerURL();
            }
            default -> throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
