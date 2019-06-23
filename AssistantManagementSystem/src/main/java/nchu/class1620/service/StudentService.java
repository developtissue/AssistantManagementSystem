package nchu.class1620.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nchu.class1620.entity.Student;
import nchu.class1620.repository.StudentLoginRepository;

/*
 * 
 * yuchao 16202128
 * 
 */


@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	private StudentLoginRepository slr; 
	
	@Override
	public Student StudentLogin(String s_id, String s_password) {
		return slr.findStudentById(s_id, s_password);
	}
	
}
