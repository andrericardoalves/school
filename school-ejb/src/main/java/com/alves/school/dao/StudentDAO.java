package com.alves.school.dao;

import java.util.List;

import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.alves.school.model.Student;

@Stateless
public class StudentDAO {

	@PersistenceContext()
	EntityManager entityManager;
	
	public void save(Student student) {
		entityManager.persist(student);
	}
	
	public Student findById(Integer id) {
	 return	entityManager.find(Student.class, id);
	}
	
	public List<Student> getAllStudents() {
		 return	entityManager
				 .createQuery("select f from Student f", Student.class).getResultList();
	}

	public void deleteById(Integer id) throws ObjectNotFoundException {
		Student student = findById(id);
		if(student == null) {
			throw new ObjectNotFoundException();
		}
		entityManager.remove(student);
	}

	public void update(Student student) throws ObjectNotFoundException {
		Student studentSaved = findById(student.getId());
		if(studentSaved == null) {
			throw new ObjectNotFoundException();
		}
		
		entityManager.merge(student);
	}
			
}
