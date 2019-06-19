package nchu.class1620.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nchu.class1620.entity.Teacher;
import nchu.class1620.repository.TeacherRepository;

/*
 * 16202128 余超
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

	@Override
	public Boolean InsertPublishRecruitment(Teacher teacher, String name, String require) {
		int id = teacherRepository.findMaxAppId()+1;
		Integer c_id = teacherRepository.FindCourseId(name);
		
		if(c_id == null) {
			return false;
		}	
		teacherRepository.InsertApplicationForm(id, require);											//新建申请表
		teacherRepository.InsertPublishRecruitment(teacher.getId(), id, c_id, require);					//往推送表写数据
		return true;
	}
}
