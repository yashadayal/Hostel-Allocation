package com.example.DAO;

import com.example.Bean.Hostel;
import com.example.Bean.Student;
import com.example.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {



    public boolean addStudent(Student student) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    public Student getStudent(int id){
        System.out.println("-->>");
        try(Session session = HibernateSessionUtil.getSession()){
            System.out.println("Try");
            Query query1 =  session.createQuery("from Student where studentId =: id");
            query1.setParameter("id",id);
            List list=query1.list();
            System.out.println(list);
            Student student = (Student)list.get(0);
            System.out.println("List to student object : "+student);
            //Student student = (Student) session.createQuery("from Student where studentId = id").list().get(0);
            //System.out.println("student"+student);
            Transaction tx = session.beginTransaction();
            tx.commit();
            session.close();
            return student;
        }
        catch (HibernateException exception) {
            System.out.println("Catch");
            System.out.println("Hibernate Exception: "+exception.getLocalizedMessage());
            return null;
        }
    }
}
