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
        
        /*String queryText = "SELECT DISTINCT a.* AS user, b.value AS value FROM TABLE_A a, TABLE_B b";
        SQLQuery sqlQuery = aSession.createSQLQuery( queryTxt );
        sqlQuery.addScalar( "value", IntegerType.INSTANCE );
        sqlQuery.setResultTransformer( Transformers.aliasToBean( ValueDto.class ) );
        return sqlQuery.list();*/
        
        
        /*Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select emp_id, emp_name, emp_salary from Employee");
        List<Object[]> rows = query.list();
        for(Object[] row : rows){
            Employee emp = new Employee();
            emp.setId(Long.parseLong(row[0].toString()));
            emp.setName(row[1].toString());
            emp.setSalary(Double.parseDouble(row[2].toString()));
            System.out.println(emp);
        }*/
        
        session.getTransaction().commit();
        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
}