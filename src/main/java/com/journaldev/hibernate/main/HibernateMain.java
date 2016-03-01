package com.journaldev.hibernate.main;

import java.util.*; 

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import com.journaldev.hibernate.model.Employer;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateMain
{
	public static void main(String[] args) {
        
        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
        /*
        emp.setName("Facebook");
        emp.setShortname("FB");
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employer ID="+emp.getId());*/
        
        /*for (Iterator iterator = rows.iterator(); iterator.hasNext();)
        {
        	Employer employer = (Employer) iterator.next();
        	emp.setId(employer.getId());
        	System.out.print("ID: " + emp.getId()); 
        	System.out.print("Name: " + emp.getName()); 
        	System.out.println("Shortname: " + emp.getShortname()); 
        }*/
        
        session.beginTransaction();
        Query q = session.createQuery("from Employer");
        
        List<Employer> employers = q.list();
	    for (Employer employer : employers) {
	        System.out.println(employer.toString());
	    }
        
        session.getTransaction().commit();
        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
}