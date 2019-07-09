/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.dao;

import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

/**
 * Interface for User DAO
 * @author Bilal Siddiqui
 */
public interface UserDAO {
    
    /**
     * Return users by requested field value pair
     * @param String field
     * @param String value
     * @return UserDTO
     */
    UserDTO getUser(String field, String value);
    
    /**
     * Return all user in database
     * @return 
     */
    UserDTO getAllUsers(); 
    
    /**
     * Create new user
     * @return
     */
    UserDTO saveUser(UserDTO user);
}
