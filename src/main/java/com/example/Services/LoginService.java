package com.example.Services;

import com.example.DAO.EmployeeDao;
import com.example.DAO.EmployeeDaoImpl;

public class LoginService {

    private EmployeeDao employeeDao;
    public boolean authenticate(String email, String password){
        employeeDao = new EmployeeDaoImpl();
        System.out.println("Service Login");
        return employeeDao.getPassword(email).equals(password);
    }

}
