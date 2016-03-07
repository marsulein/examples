package com.journaldev.hibernate.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import com.journaldev.hibernate.model.Employer;
import com.journaldev.util.EntityManagerUtil;

public class JpaMain {

	private EntityManager entityManager = EntityManagerUtil.getEntityManager();

	public static void main(String[] args)
	{
		JpaMain example = new JpaMain();
		example.listEmployer();
		/*System.out.println("After Sucessfully insertion ");
		Student student1 = example.saveStudent("Sumith");
		Student student2 = example.saveStudent("Anoop");
		System.out.println("After Sucessfully modification ");
		example.updateStudent(student1.getStudentId(), "Sumith Honai");
		example.updateStudent(student2.getStudentId(), "Anoop Pavanai");
		example.listStudent();
		System.out.println("After Sucessfully deletion ");
		example.deleteStudent(student2.getStudentId());
		example.listStudent();*/
	}

	public void listEmployer() {
		try {
			entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Employer> Employers = entityManager.createQuery("from Employer").getResultList();
			for (Iterator<Employer> iterator = Employers.iterator(); iterator.hasNext();) {
				Employer employer = (Employer) iterator.next();
				System.out.println(employer.toString());
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
}