/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.view.model;

import hr.algebra.model.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andru
 */
public class UserTableModel extends AbstractTableModel{
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        fireTableDataChanged();
    }

    public UserTableModel(List<User> users) {
        this.users = users;
    }
    
    private static final String[] COLUMN_NAMES = {
        "Id", 
        "Username", 
        "RoleID",
        "Role"};
    
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return users.get(rowIndex).getId();
            }
            case 1 -> {
                return users.get(rowIndex).getUsername();
            }
            case 2 -> {
                return users.get(rowIndex).getRoleID();
            }
            default ->
                throw new RuntimeException("No such column");
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 2; // Only Role column is editable
    }
    
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
