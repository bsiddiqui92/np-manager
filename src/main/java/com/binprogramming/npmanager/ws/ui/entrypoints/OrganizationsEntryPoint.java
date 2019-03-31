/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.binprogramming.npmanager.ws.ui.entrypoints;

import com.binprogramming.npmanager.ws.service.impl.OrganizationServiceImpl;
import com.binprogramming.npmanager.ws.shared.dto.OrganizationDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;

/**
 *
 * @author ahmed
 */

@Path("/organization")
public class OrganizationsEntryPoint {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganization() {

       String output = " This is the list of organizations:";

        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/{field}/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganization(@PathParam("field") String field, @PathParam("value") String value){
        OrganizationDTO response = null;
        try{
        response = new OrganizationServiceImpl().getOrganization(field, value);
        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return Response.status(200).entity(response).build();
        
    }
    
}