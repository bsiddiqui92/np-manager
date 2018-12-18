/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.service;

import com.binprogramming.npmanager.ws.shared.dto.UserDTO;

/**
 *
 * @author Bilal Siddiqui
 */
public interface UsersService {
    public UserDTO createUser(UserDTO user);
}
