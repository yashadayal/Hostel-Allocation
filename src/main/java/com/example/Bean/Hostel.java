package com.example.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Hostel")
public class Hostel {

    @Id
    @Column(name = "hostel_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostelId;

    @Column(name = "Floor", nullable = false)
    //postman mein post karte time use ths
    private int floor;

    @Column(name = "RoomNumber", nullable = false , unique = true)
    private int roomNo;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "StudentID", referencedColumnName ="StudentID")
    private Student student;


    public Hostel(int floor, int roomNo) {
        this.floor = floor;
        this.roomNo = roomNo;
    }

    public Hostel(int floor, int roomNo, Student student) {
        this.floor = floor;
        this.roomNo = roomNo;
        this.student = student;
    }

    public Hostel(Hostel hostel) {
        this.hostelId = hostel.hostelId;
        this.floor = hostel.floor;
        this.roomNo = hostel.roomNo;
        this.student = hostel.student;
    }

    public Hostel() {
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
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


    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "hostelId=" + hostelId +
                ", floor=" + floor +
                ", roomNo=" + roomNo +
                ", student=" + student +
                '}';
    }
}
