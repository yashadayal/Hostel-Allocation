package com.example.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Hostel")
public class Hostel {

    @Id
    @Column(name = "hostel_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostel_id;

    @Column(name = "Student_Name", nullable = false)
    private String name;

    @Column(name = "Floor", nullable = false)
    private int floor;

    @Column(name = "RoomNumber", nullable = false , unique = true)
    private int roomNo;

    @OneToOne(targetEntity = Student.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID")
    private Student studentId;


    public Hostel(String name, int floor, int roomNo) {
        this.name = name;
        this.floor = floor;
        this.roomNo = roomNo;
    }

    public Hostel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "hostel_id=" + hostel_id +
                ", name='" + name + '\'' +
                ", floor=" + floor +
                ", roomNo=" + roomNo +
                ", studentId=" + studentId +
                '}';
    }
}
