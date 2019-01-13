/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.ui.entrypoints;

import com.binprogramming.npmanager.ws.io.dao.mysql.MySqlUserDao;
import com.binprogramming.npmanager.ws.service.UsersService;
import com.binprogramming.npmanager.ws.service.impl.UsersServiceImpl;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;
import com.binprogramming.npmanager.ws.ui.model.request.CreateUserRequestModel;
import com.binprogramming.npmanager.ws.ui.model.response.UserProfileRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bilal Siddiqui
 */
@Path("/users") 
public class UsersEntryPoint {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    @Path("/createUser")
    public Response createUser(CreateUserRequestModel requestObject) {
        UserProfileRest returnValue = new UserProfileRest();

        // Prepare UserDTO
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(requestObject, userDto);
        
        // Create new user 
        UsersService userService = new UsersServiceImpl();
        UserDTO createdUserProfile = userService.createUser(userDto);
 
        //Prepare response
         BeanUtils.copyProperties(createdUserProfile, returnValue);
         returnValue.setEmail(createdUserProfile.getEmail());
         returnValue.setFirstName(createdUserProfile.getFirstName());
         returnValue.setLastName(createdUserProfile.getLastName());
         returnValue.setUserId(createdUserProfile.getUserId());
        //Response.ok().entity(returnValue).build();
        return Response.ok().entity(returnValue).build();
    }

    @Path("get")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUsers() {

        String output = " This is the list of users:";
        UserDTO[] users ;
        MySqlUserDao mySqlUserDao = new MySqlUserDao();

        users = mySqlUserDao.getAllUsers();
        List<UserProfileRest> userProfiles = new ArrayList<>();

        for(UserDTO user : users) {
            UserProfileRest userProfileRest = new UserProfileRest();
            userProfileRest.setEmail(user.getEmail());
            userProfileRest.setFirstName(user.getFirstName());
            userProfileRest.setLastName(user.getLastName());
            userProfiles.add(userProfileRest);
        }


        // code to retrieve the list of Users

        return Response.status(200).entity(userProfiles).build();

    }

}


