package com.example.Controller;

import com.example.Bean.Hostel;
import com.example.Bean.Student;
import com.example.Services.HostelService;
import com.example.Services.StudentService;
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
        int studentId = hostel.getStudent().getStudentId();
        studentService = new StudentService();
        Student student = studentService.getStudent(studentId);
        hostel.setStudent(student);
        hostelService = new HostelService();
        hostelService.addRoom(hostel);
        return hostel.toString();
    }

    @PUT
    @Path("/update/{hostelId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateRoom(@PathParam ("hostelId") Integer id, Hostel hostel){
        System.out.println("Update hostelID: "+id+" to student ID: "+hostel.getStudent().getStudentId());
        hostelService = new HostelService();
        studentService = new StudentService();
        Student student = studentService.getStudent(hostel.getStudent().getStudentId());
        hostel.setStudent(student);
        return hostelService.updateRoom(id, hostel);
    }
}