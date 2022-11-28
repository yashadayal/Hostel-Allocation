package com.example.DAO;

import com.example.Bean.Hostel;

import java.util.List;

public interface HostelDAO {

    List<Hostel> getRooms();
    boolean updateRoom(Hostel hostel);

    boolean addRoom(Hostel hostel);

}
