package com.alves.school.bo;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.Stateless;

import com.alves.school.dao.StudentDAO;
import com.alves.school.model.Student;

@Stateless
public class StudentBO {

	@EJB
	private StudentDAO dao;
	
	public void save(Student student) {
		dao.save(student);
	}
	
	public Student findById(Integer id) {
	 return	dao.findById(id);
	}
	
	public void deleteById(Integer id) throws ObjectNotFoundException {
		dao.deleteById(id);
	}
	
	
	public List<Student> getAllStudents() {
	  return dao.getAllStudents();
	}

	public void update(Student student) throws ObjectNotFoundException {
		dao.update(student);
	}
}
