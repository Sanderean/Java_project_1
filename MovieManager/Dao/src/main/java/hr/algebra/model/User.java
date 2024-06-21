/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author andru
 */
public final class User implements Comparable<User> {

    private int id;

    @Override
    public String toString() {
        return "Username: " + username ; 
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public int getRoleID() {
        return roleID;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    private String username;
    private String password;
    private int roleID;

    public User(int id, String Username, String Password, int roleID) {
        this.id = id;
        this.username = Username;
        this.password = Password;
        this.roleID = roleID;
    }

    public User(String Username, String Password) {
        this.username = Username;
        this.password = Password;
    }

    public User() {
    }

    @Override
    public int compareTo(User o) {
        return username.compareTo(o.username);
    }

}
