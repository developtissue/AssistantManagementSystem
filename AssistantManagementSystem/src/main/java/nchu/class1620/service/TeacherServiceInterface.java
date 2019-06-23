package nchu.class1620.service;

import nchu.class1620.entity.Admin;
import nchu.class1620.entity.Teacher;

public interface TeacherServiceInterface {
	
	public Teacher TeacherLogin(String teacher_id, String teacher_password);
	
	public Boolean InsertPublishRecruitment(Teacher teacher, String name ,String require);
}
