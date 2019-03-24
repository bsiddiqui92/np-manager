/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.service;

import com.binprogramming.npmanager.ws.dao.DAO;
import com.binprogramming.npmanager.ws.dao.DAOFactory;
import com.binprogramming.npmanager.ws.dao.User;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

/**
 * UserServiceImpl Service layer for user requests.
 * @author Bilal Siddiqui
 */
public class UserServiceImpl implements UsersService {
    
    private static int MYSQL_DAO = 1;

    /**
     * User UserDAO instance.
     */
    private User UserDAO;

    public UserServiceImpl () {
        DAOFactory daoFactory = new DAOFactory();
        DAO dao = daoFactory.getDAOFactory(this.MYSQL_DAO);

        this.UserDAO = dao.user();
    }

    /**
     * Retrieve user information using request field and value pair.
     * @param String field table column name being used to retrieve data.
     * @param String value value to search for in table.
     * @return
     */
    public UserDTO getUser(String field, String value) {

        UserDTO returnValue = this.UserDAO.getUser(field, value);

        return returnValue;
    }

    public UserDTO createUser(UserDTO dto) {

        //TODO: Implement validation
        dto = this.UserDAO.saveUser(dto);

        return dto;
    }
}
