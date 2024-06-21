/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import hr.algebra.model.ParsedData;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andru
 */
public class UploadMovieTableModel extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES = {
        "Title",
        "Publish date",
        "Description",
        "Duration",
        "Year",
        "Poster URL",
        "Trailer URL",
        "Directors",
        "Actors",
        "Genres"};
    
    private Set<ParsedData> parsedData;

    public UploadMovieTableModel(Set<ParsedData> parsedData) {
        this.parsedData = parsedData;
    }

    public void setMovies(Set<ParsedData> parsedData) {
        this.parsedData = parsedData;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return parsedData.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
        }
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ParsedData[] parsedDataArray = parsedData.toArray(new ParsedData[0]);
        switch (columnIndex) {
            case 0 -> {
                return parsedDataArray[rowIndex].getTitle();
            }
            case 1 -> {
                return parsedDataArray[rowIndex].getPubDate().format(ParsedData.DATE_FORMATTER);
            }
            case 2 -> {
                return parsedDataArray[rowIndex].getDescription();
            }
            case 3 -> {
                return parsedDataArray[rowIndex].getDuration();
            }
            case 4 -> {
                return parsedDataArray[rowIndex].getYear();
            }
            case 5 -> {
                return parsedDataArray[rowIndex].getPosterURL();
            }
            case 6 -> {
                return parsedDataArray[rowIndex].getTrailerURL();
            }
            case 7 -> {
                return parsedDataArray[rowIndex].getDir();
            }
            case 8 -> {
                return parsedDataArray[rowIndex].getActors();
            }
            case 9 -> {
                return parsedDataArray[rowIndex].getGenre();
            }
            default -> throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
