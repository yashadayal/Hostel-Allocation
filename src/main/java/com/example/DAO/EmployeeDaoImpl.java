package com.example.DAO;

import com.example.Bean.Employee;
import com.example.Bean.Student;
import com.example.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{


    public String getPassword(String email){
        try(Session session = HibernateSessionUtil.getSession()){
            Query query1 =  session.createQuery("from Employee where email =: email");
            query1.setParameter("email",email);
            List list=query1.list();
            System.out.println("list"+list);
            Employee employee = (Employee)list.get(0);// as list is not getting converting to employee object
            Transaction tx = session.beginTransaction();
            tx.commit();
            session.close();
            return employee.getPassword();
        }
        catch (HibernateException exception) {
            System.out.println("Catch");
            System.out.println("Hibernate Exception: "+exception.getLocalizedMessage());
            return null;
        }
    }

    public boolean addEmployee(Employee employee){
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
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
