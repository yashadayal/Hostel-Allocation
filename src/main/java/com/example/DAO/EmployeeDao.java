package com.example.DAO;

import com.example.Bean.Employee;

public interface EmployeeDao {

    public String getPassword(String email);

    public boolean addEmployee(Employee employee);
}
