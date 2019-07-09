package com.binprogramming.npmanager.ws.entrypoints;

import com.binprogramming.npmanager.ws.model.Volunteer;
import com.binprogramming.npmanager.ws.request.UpdateVolunteerRequestModel;
import com.binprogramming.npmanager.ws.service.VolunteerService;
import com.binprogramming.npmanager.ws.service.impl.VolunteerServiceImpl;
import com.binprogramming.npmanager.ws.shared.dto.VolunteerDTO;
import org.springframework.beans.BeanUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/volunteers")
public class VolunteersEntryPoint {

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVolunteersById(@PathParam("id") Integer id) {
        try{
            VolunteerService volunteerService = new VolunteerServiceImpl();
            List<Volunteer> volunteers = volunteerService.getVolunteersByOrganization(id);

            return Response.status(200).entity(volunteers).build();
        } catch (Exception ex) {
            return Response.status(500).entity("Failed to retrieve volunteers.").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateVolunteers(UpdateVolunteerRequestModel requestObject) {
        try {
            VolunteerService volunteerService = new VolunteerServiceImpl();
            VolunteerDTO volunteerDTO = new VolunteerDTO();
            volunteerDTO.setVolunteer(requestObject.getVolunteers());
            return Response.status(200).entity(volunteerService.createVolunteers(volunteerDTO)).build();
        } catch (Exception ex) {
            return Response.status(500).entity("Failed to update volunteers.").build();
        }
    }

//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deleteVolunteers(List<Volunteer> requestBody) {
//        try {
//            VolunteerService volunteerService = new VolunteerServiceImpl();
//            volunteerService.deleteVolunteers(requestBody);
//        } catch (Exception ex) {
//            return Response.status(500).entity("Failed to delete volunteers.").build();
//        }
//    }
}
