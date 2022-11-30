package com.example.DAO;

import com.example.Bean.Student;

public interface StudentDAO {

    public Student getStudent(int studentId);


    boolean addStudent(Student student);
}
