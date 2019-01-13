/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.service.impl;

import com.binprogramming.npmanager.ws.io.dao.mysql.MySqlUserDao;
import com.binprogramming.npmanager.ws.io.entity.UserEntity;
import com.binprogramming.npmanager.ws.service.UsersService;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;
import com.binprogramming.npmanager.ws.utils.PasswordUtils;
import com.binprogramming.npmanager.ws.utils.UserProfileUtils;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 *
 * @author Bilal Siddiqui
 */
public class UsersServiceImpl implements UsersService {

    UserProfileUtils userProfileUtils = new UserProfileUtils();
    
    public UserDTO createUser(UserDTO user) {
        UserDTO newUser = new UserDTO();
        
        // Validate fields
        this.userProfileUtils.validateRequiredFields(user);
        // Check if use exists
        MySqlUserDao userDao = new MySqlUserDao();
        if(userDao.getUserByName(user.getUserName()) == null) {

            // Create Entity Object
            //UserDTO userDTO = new UserDTO();


            // Generate secure public user id

            // Generate salt
            PasswordUtils passwordUtils = new PasswordUtils();
            byte[] salt = passwordUtils.getNextSalt();

            // Generate secure password
            byte[] hash = passwordUtils.hash(user.getPassword().toCharArray(),salt);

            // Record data in db

            newUser.setUserName(user.getUserName());
            newUser.setLastName(user.getLastName());
            newUser.setFirstName(user.getFirstName());
            newUser.setEmail(user.getEmail());
            newUser.setSalt(new String(salt));
            newUser.setEncryptedPassword(new String(hash));
            newUser.setUserId("1");

            userDao.createUser(newUser);

        }
        // Return UserProfile
        
        return newUser;
    }




}
