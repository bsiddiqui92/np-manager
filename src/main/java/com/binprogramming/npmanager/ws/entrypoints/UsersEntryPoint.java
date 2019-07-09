package com.binprogramming.npmanager.ws.entrypoints;

import com.binprogramming.npmanager.ws.service.UserService;
import com.binprogramming.npmanager.ws.service.impl.UserServiceImpl;
import com.binprogramming.npmanager.ws.shared.dto.UserDTO;
import com.binprogramming.npmanager.ws.request.CreateUserRequestModel;
import com.binprogramming.npmanager.ws.response.UserProfileRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;

@Path("/users") 
public class UsersEntryPoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

       String output = " This is the list of users:";
//
//        UserDTO response = new UserServiceImpl();
//        // code to retrieve the list of Users

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{field}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("field") String field, @PathParam("value") String value) {

        UserDTO response = new UserServiceImpl().getUser(field, value);
        return Response.status(200).entity(response).build();

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public UserProfileRest createUser(CreateUserRequestModel requestObject) {
        UserProfileRest returnValue = new UserProfileRest();

        // Prepare UserDTO
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(requestObject, userDto);
        
        // Create new user 
        UserService userService = new UserServiceImpl();
        UserDTO createdUserProfile = userService.createUser(userDto);
 
        //Prepare response
         BeanUtils.copyProperties(createdUserProfile, returnValue);
        //Response.ok().entity(userDto).build();
        return returnValue;
    }
}


