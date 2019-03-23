/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.service.impl;

import com.binprogramming.npmanager.ws.dao.DAO;
import com.binprogramming.npmanager.ws.dao.DAOFactory;
import com.binprogramming.npmanager.ws.service.UsersService;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

/**
 *
 * @author Bilal Siddiqui
 */
public class UsersServiceImpl implements UsersService {

    DAO Dao = null;

    public UsersServiceImpl() {
    }
    
    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = new UserDTO(); 


        return returnValue; 
    }




}
