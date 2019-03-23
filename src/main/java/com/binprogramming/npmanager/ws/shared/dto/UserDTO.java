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
    private String userId;
    private int permissionId;
    private HashMap permissions;
    
    /**
     * @return the serialVerionUID
     */
    public static long getSerialVerionUID() {
        return serialVerionUID;
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param set userName
     */
    public void setUserName(String userName) { this.userName = userName; }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
