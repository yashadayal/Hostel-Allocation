package com.example.Services;

import com.example.Bean.Hostel;
import com.example.DAO.HostelDAO;
import com.example.DAO.HostelDAOImpl;

import java.util.List;

public class HostelService {

    private HostelDAO hostelDAO;
    public List<Hostel> getRooms()
    {
        hostelDAO = new HostelDAOImpl();
        return hostelDAO.getRooms();
    }
    public boolean updateRoom(Integer hostelId, Hostel hostel)
    {
        hostelDAO = new HostelDAOImpl();
        return hostelDAO.updateRoom(hostelId, hostel);
    }

    public boolean addRoom(Hostel hostel)
    {
        hostelDAO = new HostelDAOImpl();
        return this.hostelDAO.addRoom(hostel);
    }
}
