package com.example.Controller;

import com.example.Bean.Employee;
import com.example.DAO.EmployeeDao;
import com.example.Services.LoginService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
public class LoginController {

    private LoginService loginService;

    @POST
    @Path("/auth")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean authenticate(Employee e){
        loginService = new LoginService();
        System.out.println("Controller Login");
        return loginService.authenticate(e.getEmail(), e.getPassword());
    }
}
