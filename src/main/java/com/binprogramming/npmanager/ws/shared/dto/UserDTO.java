package com.binprogramming.npmanager.ws.shared.dto;

import com.binprogramming.npmanager.ws.model.User;

import java.io.Serializable;
import java.util.HashMap;

/**
 * DTO for user data.
 * @author Bilal Siddiqui
 */
public class UserDTO implements Serializable {
    private static final long serialVerionUID = 1L; 

    private User user;
    private HashMap permissions;

    public static long getSerialVerionUID() {
        return serialVerionUID;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public HashMap getPermissions() {
        return permissions;
    }

    public void setPermissions(HashMap permissions) {
        this.permissions = permissions;
    }
}
