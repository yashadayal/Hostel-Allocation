package com.example.Controller;

import com.example.Bean.Hostel;
import com.example.Bean.Student;
import com.example.Services.HostelService;
import com.example.Services.StudentService;
import com.example.exception.APIRequestException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/hostel")
public class HostelController {

    private HostelService hostelService;
    private StudentService studentService;

    @GET
    @Path("/rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hostel> getRooms() {
        System.out.println("Get Rooms Called!!!");
        hostelService = new HostelService();
        return hostelService.getRooms();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addRoom(Hostel hostel){
        int rollNo = hostel.getStudent() == null ? 0 : hostel.getStudent().getRollNo();
        System.out.println("Add Rooms: "+rollNo);
        hostelService = new HostelService();
        if(rollNo != 0) {
            studentService = new StudentService();
            Student student = studentService.getStudent(rollNo);
            if(student == null)
                throw new APIRequestException("Student roll number: "+rollNo+" not valid!");
            hostel.setStudent(student);
        }else{
            hostel.setStudent(null);
        }
        hostelService.addRoom(hostel);
        return hostel.toString();
    }

    @PUT
    @Path("/update/{hostelId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateRoom(@PathParam ("hostelId") Integer id, Hostel hostel){
        int rollNo = hostel.getStudent().getRollNo();
        System.out.println("Update hostelID: "+id+" to student ID: "+hostel.getStudent().getRollNo());
        hostelService = new HostelService();
        if(rollNo != 0) {
            studentService = new StudentService();
            Student student = studentService.getStudent(rollNo);
            hostel.setStudent(student);
        }else{
            hostel.setStudent(null);
        }
        return hostelService.updateRoom(id, hostel);
    }
}