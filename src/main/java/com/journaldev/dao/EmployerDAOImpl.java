package com.journaldev.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employer;

public class EmployerDAOImpl implements EmployerDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public void save(Employer emp) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(emp);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    public List<Employer> list() {
        Session session = this.sessionFactory.openSession();
        List<Employer> employerList = session.createQuery("from Employer").list();
        session.close();
        return employerList;
    }
}