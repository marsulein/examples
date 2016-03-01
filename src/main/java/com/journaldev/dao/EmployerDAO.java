package com.journaldev.dao;

import java.util.List;

import com.journaldev.hibernate.model.Employer;

public interface EmployerDAO {
	
	public void save(Employer emp);
	
	public List<Employer> list();
}