package com.binprogramming.npmanager.ws.service.impl;

import com.binprogramming.npmanager.ws.dao.DAOFactory;
import com.binprogramming.npmanager.ws.dao.VolunteerDAO;
import com.binprogramming.npmanager.ws.model.Volunteer;
import com.binprogramming.npmanager.ws.service.VolunteerService;
import com.binprogramming.npmanager.ws.shared.dto.VolunteerDTO;

import java.util.List;

public class VolunteerServiceImpl implements VolunteerService {

    /**
     * Dao VolunteerDao
     */
    private VolunteerDAO dao;

    /**
     * Constructor for
     */
    public VolunteerServiceImpl() {
        this.dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO).volunteer();
    }

    /**
     * Retuns List of volunteers by organization.
     * @param organizationId Integer id for organization.
     * @return
     */
    public List<Volunteer> getVolunteersByOrganization(Integer organizationId) {
        return this.dao.getVolunteers(Volunteer.ORGANIZATION_ID, Integer.toString(organizationId));
    }


    public Boolean createVolunteers(VolunteerDTO volunteerDTO) throws Exception {
        try {
            return this.dao.createVolunteers(volunteerDTO);
        } catch (Exception ex) {
            throw new Exception("Failed to create records.");
        }
    }



}
