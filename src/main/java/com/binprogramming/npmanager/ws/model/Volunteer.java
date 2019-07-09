package com.binprogramming.npmanager.ws.model;

public class Volunteer {

    /**
     * Member variables for volunteer class.
     */
    private Integer id;
    private Integer organizationId;
    private String firstName;
    private String lastName;
    private String email;
    private String zip;
    private String preferredContact;
    private String interestedIn;


    /**
     * Constant declaration for Volunteer field names.
     */
    public static final String ORGANIZATION_ID = "organization_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String ZIP = "zip";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Integer id) {
        this.organizationId = id;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPreferredContact() {
        return preferredContact;
    }

    public void setPreferredContact(String preferredContact) {
        this.preferredContact = preferredContact;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
    }
}
