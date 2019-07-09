/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.service.impl;

import com.binprogramming.npmanager.ws.dao.DAOFactory;
import com.binprogramming.npmanager.ws.dao.UserDAO;
import com.binprogramming.npmanager.ws.service.UserService;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

/**
 * UserServiceImpl Service layer for user requests.
 * @author Bilal Siddiqui
 */
public class UserServiceImpl implements UserService {

    private static int MYSQL_DAO = 1;

    /**
     * User UserDAO instance.
     */
    private UserDAO dao;

    public UserServiceImpl () {
        this.dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL_DAO).user();
    }

    /**
     * Retrieve user information using request field and value pair.
     * @param String field table column name being used to retrieve data.
     * @param String value value to search for in table.
     * @return
     */
    public UserDTO getUser(String field, String value) {

        UserDTO returnValue = this.dao.getUser(field, value);

        return returnValue;
    }

    public UserDTO createUser(UserDTO dto) {

        //TODO: Implement validation
        dto = this.dao.saveUser(dto);

        return dto;
    }
}