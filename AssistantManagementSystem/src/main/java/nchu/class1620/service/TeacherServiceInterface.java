package nchu.class1620.service;

import nchu.class1620.entity.Admin;
import nchu.class1620.entity.Teacher;

public interface TeacherServiceInterface {
	
	public Teacher TeacherLogin(int teacher_id, int teacher_password);
	
}
