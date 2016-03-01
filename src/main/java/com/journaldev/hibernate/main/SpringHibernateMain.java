package com.journaldev.hibernate.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.journaldev.dao.EmployerDAO;
import com.journaldev.hibernate.model.Employer;

public class SpringHibernateMain {

	private static Logger logger = Logger.getLogger(SpringHibernateMain.class);
	
	public static void main(String[] args) {
		 
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
         
        EmployerDAO EmployerDAO = context.getBean(EmployerDAO.class);
         
        Employer emp = new Employer();
        
        /*person.setName("Pankaj"); person.setCountry("India");
        EmployerDAO.save(person);
        System.out.println("Employer::"+emp);
        */
        
        List<Employer> list = EmployerDAO.list();
         
        for(Employer p : list){
            System.out.println("Employer List::"+p);
            logger.info("Employer List::"+p);
        }
        
        //close resources
        context.close();    
    }
}