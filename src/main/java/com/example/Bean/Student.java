package com.example.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "StudentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "RollNumber", unique = true, nullable = false)
    private int rollNo;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    public Student(int rollNo, String firstName, String lastName, String email, String photographPath, float cgpa, int totalCredits, int graduationYear) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photographPath = photographPath;
        this.cgpa = cgpa;
        this.totalCredits = totalCredits;
        this.graduationYear = graduationYear;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotographPath() {
        return photographPath;
    }

    public void setPhotographPath(String photographPath) {
        this.photographPath = photographPath;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    private String email;

    private String photographPath;
    private float cgpa;
    private int totalCredits;
    private int graduationYear;
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", rollNo=" + rollNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", photographPath='" + photographPath + '\'' +
                ", cgpa=" + cgpa +
                ", totalCredits=" + totalCredits +
                ", graduationYear=" + graduationYear +
                '}';
    }
}
