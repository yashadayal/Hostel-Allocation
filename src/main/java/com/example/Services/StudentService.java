package com.example.Services;

import com.example.Bean.Student;
import com.example.DAO.StudentDAO;
import com.example.DAO.StudentDAOImpl;

public class StudentService {

    private StudentDAO studentDAO;
    public Student getStudent(int studentId){
        studentDAO = new StudentDAOImpl();
        System.out.println("getStudentService!");
        return studentDAO.getStudent(studentId);
    }
}
