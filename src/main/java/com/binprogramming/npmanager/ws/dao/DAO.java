package com.binprogramming.npmanager.ws.dao;


public interface DAO {

    /** Return Instance of user DAO.
     * @return UserDAO
     */
    User user();

    /** Return Instance of user DAO.
     * @return UserDAO
     */
    Volunteer volunteer();

    /**
     * Return Instance of organization DAO.
     * @return OrganizationDAO
     */
    Organization organization();

    public Organization Organization();
}
