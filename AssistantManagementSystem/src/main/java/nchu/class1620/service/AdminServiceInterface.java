package nchu.class1620.service;

import java.util.List;

import nchu.class1620.dto.StudentApplyInformation;
import nchu.class1620.entity.Admin;
import nchu.class1620.entity.Assistant;

/*
 * 16202128 ”‡≥¨
 * 
 */
public interface AdminServiceInterface {

	
	public Admin AdminLogin(int admin_id, int admin_password);
	
	public List<StudentApplyInformation> findAllStudentApplyIn();
	
	public StudentApplyInformation findStudentApplyInforByStuid(int id);
	
	public void UpdateStudentApplyInformation(String Comment);
	
	
}
