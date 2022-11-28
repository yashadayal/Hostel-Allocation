package com.example.DriverClass;


import com.example.Bean.Hostel;
import com.example.Bean.Student;
import com.example.DAO.HostelDAO;
import com.example.DAO.HostelDAOImpl;

public class Application {
    public static void main(String[] args){
        System.out.println("Application Started");
        runApplication();
        System.out.println("End");
    }

    private static void runApplication() {

        Hostel hostel1 = new Hostel("Bhaskara",4,421);
        Student stud1  = new Student(202163,"Khushal","Abrol","abc@gmail.com","xyz",4,20,2022);
        hostel1.setStudentId(stud1);

        HostelDAO HostelDAO= new HostelDAOImpl();
        if(HostelDAO.addRoom(hostel1)){
            System.out.println("Room added Successfully");
        }
        else
            System.out.println("Something went wrong");
    }
}