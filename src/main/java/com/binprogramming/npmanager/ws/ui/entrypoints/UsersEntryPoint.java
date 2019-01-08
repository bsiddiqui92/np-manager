/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.ui.entrypoints;

import com.binprogramming.npmanager.ws.service.UsersService;
import com.binprogramming.npmanager.ws.service.impl.UsersServiceImpl;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;
import com.binprogramming.npmanager.ws.ui.model.request.CreateUserRequestModel;
import com.binprogramming.npmanager.ws.ui.model.response.UserProfileRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;

/**
 *
 * @author Bilal Siddiqui
 */
@Path("/users") 
public class UsersEntryPoint {

    @Path("/createUser")
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
        //Response.ok().entity(userDto).build();
        return returnValue;
    }

    @GET
    public Response getUsers() {

        String output = " This is the list of users:";

        // code to retrieve the list of Users

        return Response.status(200).entity(output).build();

    }

}


