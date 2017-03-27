package com.spring.student.tracker.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.student.tracker.entity.Student;

@Repository
public class StudentDAOimpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// execute query ... sort by last name
		List<Student> students = session.createQuery("from Student order by lastName", Student.class).getResultList();
	        
	        
	        
	        //return the results
	        
	        return students;
	}

	@Override
	public void saveStudent(Student theStudent) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save new student
		currentSession.saveOrUpdate(theStudent);
	}

	@Override
	public Student getStudent(int theId) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//
		Student theStudent = currentSession.get(Student.class, theId);
				
				return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete student based on id
		currentSession.delete(currentSession.get(Student.class, theId));
		
	}

}
