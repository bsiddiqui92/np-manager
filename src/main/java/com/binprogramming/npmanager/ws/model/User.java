package com.binprogramming.npmanager.ws.model;

import java.util.*;

public class User {

    /**
     * Member variables for user class
     */
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String zip;

    /**
     * Constant declaration for user members
     */
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String ZIP = "lastName";

    /**
     * Array containing all user info
     */
    private Map user;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Return hash map containing all user data.
     * @return HashMap user
     */
    public Map getUser() {

        Map<String, String> user = new HashMap<>();

        user.put(FIRST_NAME, this.getFirstName());
        user.put(LAST_NAME, this.getLastName());
        user.put(EMAIL, this.getEmail());
        user.put(ADDRESS, this.getAddress());
        user.put(ZIP, this.getZip());

        return user;
    }

}
