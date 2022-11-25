package com.example.Controller;

import com.example.Bean.Hostel;
import com.example.Services.HostelService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/hostel")
public class HostelController {

    private HostelService hostelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rooms")
    public List<Hostel> getRooms() {
        hostelService = new HostelService();
        return hostelService.getRooms();
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateRoom(Hostel hostel){
        hostelService = new HostelService();
        return hostelService.updateRoom(hostel);
    }
}