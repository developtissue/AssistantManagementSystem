package nchu.class1620.service;

import java.util.List;

import nchu.class1620.dto.AssistantAllInformation;
import nchu.class1620.dto.StudentApplyInformation;
import nchu.class1620.entity.Admin;
import nchu.class1620.entity.Assistant;

/*
 * 16202128 �೬
 * 
 */
public interface AdminServiceInterface {

	
	public Admin AdminLogin(String admin_id, String admin_password);
	
	public List<StudentApplyInformation> findAllStudentApplyIn();
	
	public StudentApplyInformation findStudentApplyInforByStuid(int id);
	
	public void FailedUpdateStudentApplyInformation(int id , String Comment);
	
	public void SuccessUpdateStudentApplyInformation(StudentApplyInformation studentApplyInformation);
	
	public List<AssistantAllInformation> FindAllAssistantInformation();
	
}
