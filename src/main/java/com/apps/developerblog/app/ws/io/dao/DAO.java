/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apps.developerblog.app.ws.io.dao;

import com.apps.developerblog.app.ws.shared.dto.UserDTO;

/**
 *
 * @author Bilal Siddiqui
 */
public interface DAO {
    /**
     * Method to open connection to database
     */
    public void openConnection(); 
    
    /**
     * Method for userDTO
     * @param userName 
     */
    public UserDTO getUserByName(String userName);
    
    /**
     * Method to connection to database
     */
    public void closeConnection(); 
}
