/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apps.developerblog.app.ws.io.dao.mysql;

import com.apps.developerblog.app.ws.io.dao.UserDao;
import com.apps.developerblog.app.ws.shared.dto.UserDTO;

/**
 *
 * @author Bilal Siddiqui
 */
public class MySqlUserDao implements UserDao {
    
    public UserDTO getUserByName(String userName) {
        return new UserDTO(); 
    }
    
    public UserDTO getAllUsers() {
        return new UserDTO(); 
    }
    
    public UserDTO createUser() {
        return new UserDTO(); 
    }
    
}
