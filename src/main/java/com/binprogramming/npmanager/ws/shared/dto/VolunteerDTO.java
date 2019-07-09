package com.binprogramming.npmanager.ws.shared.dto;

import com.binprogramming.npmanager.ws.model.Volunteer;

import java.io.Serializable;
import java.util.List;

public class VolunteerDTO implements Serializable {

    private static final long serialVerionUID = 1L;

    private List<Volunteer> volunteers;

    public static long getSerialVerionUID() {
        return serialVerionUID;
    }

    public void setVolunteer(List<Volunteer>  volunteer) {
        this.volunteers = volunteer;
    }

    public List<Volunteer> getVolunteers() {
        return this.volunteers;
    }
}
