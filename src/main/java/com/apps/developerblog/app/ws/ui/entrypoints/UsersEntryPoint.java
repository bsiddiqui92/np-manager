/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apps.developerblog.app.ws.ui.entrypoints;

import com.apps.developerblog.app.ws.service.UsersService;
import com.apps.developerblog.app.ws.service.impl.UsersServiceImpl;
import com.apps.developerblog.app.ws.shared.dto.UserDTO;
import com.apps.developerblog.app.ws.ui.model.request.CreateUserRequestModel;
import com.apps.developerblog.app.ws.ui.model.response.UserProfileRest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Bilal Siddiqui
 */
@Path("/users") 
public class UsersEntryPoint {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public UserProfileRest createUser(CreateUserRequestModel requestObject) {
        UserProfileRest returnValue = new UserProfileRest();
        
        // Prepare UserDTO
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(requestObject, userDto);
        
        // Create new user 
        UsersService userService = new UsersServiceImpl();
        UserDTO createdUserProfile = userService.createUser(userDto);
 
        //Prepare response
         BeanUtils.copyProperties(createdUserProfile, returnValue);
         
        return returnValue;
    }
}


