package com.example.DriverClass;


import com.example.Bean.Hostel;
import com.example.Bean.Student;
import com.example.DAO.HostelDAO;
import com.example.DAO.HostelDAOImpl;
import com.example.DAO.StudentDAO;
import com.example.DAO.StudentDAOImpl;

public class Application {
    public static void main(String[] args){
        System.out.println("Application Started");
        runApplication();
        System.out.println("End");
    }

    private static void runApplication() {

        Student stud1  = new Student(2021063,"Jayesh","Dayal","abc@gmail.com","xyz",4,20,2023);
        Hostel hostel1 = new Hostel();
        hostel1.setFloor(2);
        hostel1.setRoomNo(156);
        hostel1.setStudent(stud1);

        Student stud2 = new Student(2022137,"Yasha","Dayal","yasha@gmail.com","rtgs",3.3,16,2024);

        HostelDAO hostelDAO= new HostelDAOImpl();
        StudentDAO studentDAO = new StudentDAOImpl();
        if(studentDAO.addStudent(stud1)){
            System. out.println("Student added Successfully");
        }
        else
            System.out.println("Something went wrong");

        if(hostelDAO.addRoom(hostel1)){
            System.out.println("Room added Successfully");
        }
        else
            System.out.println("Something went wrong");
    }
}