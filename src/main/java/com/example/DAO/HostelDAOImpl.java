package com.example.DAO;

import com.example.Bean.Hostel;

import com.example.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HostelDAOImpl implements HostelDAO{

    @Override
    public boolean updateRoom(Hostel hostel) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(hostel);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public List<Hostel> getRooms() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Hostel> roomList = new ArrayList<>();
            for (final Object room : session.createQuery("from Hostel ").list()) {
                roomList.add((Hostel) room);
            }
            return roomList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean addRoom(Hostel hostel) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(hostel);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
