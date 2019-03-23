/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.dao.mysql;

import com.binprogramming.npmanager.ws.dao.User;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

import java.sql.Connection;

/**
 *
 * @author Bilal Siddiqui
 */
public class MySqlUserDAO implements User {

    Connection conn = null;

    MySqlUserDAO (Connection conn) {
        this.conn = conn;
    }

    @Override
    public UserDTO getUserByName(String userName) {
        return null;
    }

    @Override
    public UserDTO getAllUsers() {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return null;
    }
}
