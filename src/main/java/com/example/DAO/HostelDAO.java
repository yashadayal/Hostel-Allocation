package com.example.DAO;

import com.example.Bean.Hostel;
import com.example.Bean.Student;

import java.util.List;

public interface HostelDAO {

    List<Hostel> getRooms();
    boolean updateRoom(Integer hostelId, Hostel hostel);

    boolean addRoom(Hostel hostel);

}
