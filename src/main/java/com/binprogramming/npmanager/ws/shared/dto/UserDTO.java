/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.shared.dto;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Bilal Siddiqui
 */
public class UserDTO implements Serializable {
    private static final long serialVerionUID = 1L; 
    private long id;
    private String userName;
    private String firstName; 
    private String lastName; 
    private String email; 
    private String phone;
    private String address;
    private String state;
    private String city;
    private String zip;
    private HashMap permissions;
    
    /**
     * @return the serialVerionUID
     */
    public static long getSerialVerionUID() {
        return serialVerionUID;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public HashMap getPermissions() {
        return permissions;
    }

    public void setPermissions(HashMap permissions) {
        this.permissions = permissions;
    }
}
