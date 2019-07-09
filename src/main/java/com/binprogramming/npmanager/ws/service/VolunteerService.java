package com.binprogramming.npmanager.ws.service;

import com.binprogramming.npmanager.ws.model.Volunteer;
import com.binprogramming.npmanager.ws.shared.dto.VolunteerDTO;

import java.util.List;

public interface VolunteerService {

    /**
     * Return list of volunteers.
     * @param organizationId integer id for organization.
     * @return array of volunteers to return.
     */
    List<Volunteer> getVolunteersByOrganization(Integer organizationId);

    /**
     * Creates records for volunteers.
     * @param volunteers list of volunteers.
     * @return
     */
    Boolean createVolunteers(VolunteerDTO volunteers) throws Exception;

}
