package com.binprogramming.npmanager.ws.request;

import com.binprogramming.npmanager.ws.model.Volunteer;

import java.util.List;

public class UpdateVolunteerRequestModel {

    private List<Volunteer> volunteers;

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }
}
