package com.binprogramming.npmanager.ws.dao;

import com.binprogramming.npmanager.ws.model.Volunteer;
import com.binprogramming.npmanager.ws.shared.dto.VolunteerDTO;

import java.util.List;

public interface VolunteerDAO {
    /**
     * Get volunteers by field/value pair.
     * @param value
     * @param field
     * @return list of volunteers.
     */
    List getVolunteers(String value, String field);

    /**
     * Add volunteers to
     * @param volunteerDTO
     * @return
     */
    Boolean createVolunteers(VolunteerDTO volunteerDTO);
}
