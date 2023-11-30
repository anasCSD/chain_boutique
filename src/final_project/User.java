/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_project;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author hp
 */
public class User implements Serializable{
    private int id;
    private String name;
    private int contact;
    private String address;
    private LocalDate dob;
    
    private String pass;
    private String userType;

    public User() {
    }

    
    public User(int id, String name, int contact, String address, LocalDate dob, String pass, String userType) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.dob = dob;
        this.pass = pass;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    

    public User(int id, String pass, String userType) {
        this.id = id;
        this.pass = pass;
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", pass=" + pass + ", userType=" + userType + '}';
    }

    
    
    
    
    
}
