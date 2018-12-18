/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.io.dao.mysql;

import com.binprogramming.npmanager.ws.io.dao.UserDao;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

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
