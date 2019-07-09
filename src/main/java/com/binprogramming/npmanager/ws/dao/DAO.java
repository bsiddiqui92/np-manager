package com.binprogramming.npmanager.ws.dao;


public interface DAO {

    /** Return Instance of user DAO.
     * @return UserDAO
     */
    UserDAO user();

    /** Return Instance of volunteer DAO.
     * @return VolunteerDao
     */
    VolunteerDAO volunteer();

    /**
     * Return Instance of organization DAO.
     * @return OrganizationDAO
     */
    OrganizationDAO organization();
}
