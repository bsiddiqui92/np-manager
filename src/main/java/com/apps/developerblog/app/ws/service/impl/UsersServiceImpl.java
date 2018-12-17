/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apps.developerblog.app.ws.service.impl;

import com.apps.developerblog.app.ws.service.UsersService;
import com.apps.developerblog.app.ws.shared.dto.UserDTO;
import com.apps.developerblog.app.ws.utils.UserProfileUtils;

/**
 *
 * @author Bilal Siddiqui
 */
public class UsersServiceImpl implements UsersService {

    UserProfileUtils userProfileUtils = new UserProfileUtils();
    
    public UserDTO createUser(UserDTO user) {
        UserDTO returnValue = new UserDTO(); 
        
        // Validate fields
        this.userProfileUtils.validateRequiredFields(user);
        // Check if use exists
        
        // Create Entity Object
        
        // Generate secure public user id
        
        // Generate salt
        
        // Generate secure password
        
        // Record data in db
        
        // Return UserProfile
        
        return returnValue; 
    }
    
}
