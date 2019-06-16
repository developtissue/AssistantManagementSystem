package nchu.class1620.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nchu.class1620.entity.Teacher;
import nchu.class1620.repository.TeacherRepository;

/*
 * 16202128 ”‡≥¨
 * 
 */
@Service 
public class TeacherService implements TeacherServiceInterface{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public Teacher TeacherLogin(int teacher_id, int teacher_password) {
		return teacherRepository.findTeacherById(teacher_id, teacher_password);
	}

}
