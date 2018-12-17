/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apps.developerblog.app.ws.service;

import com.apps.developerblog.app.ws.shared.dto.UserDTO;

/**
 *
 * @author Bilal Siddiqui
 */
public interface UsersService {
    public UserDTO createUser(UserDTO user);
}
