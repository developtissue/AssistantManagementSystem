package nchu.class1620.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nchu.class1620.dto.AssistantAllInformation;
import nchu.class1620.dto.StudentApplyInformation;
import nchu.class1620.entity.Admin;
import nchu.class1620.repository.AdminRepository;
import nchu.class1620.repository.AssistantAllInformationRepository;
import nchu.class1620.repository.AssistantRepository;
import nchu.class1620.repository.OwnAssistantRepository;
import nchu.class1620.repository.StudentApplyInformationRepository;

/*
 * 16202128 余超
 * 
 */
@Service
public class AdminService implements AdminServiceInterface{

	@Autowired
	private AdminRepository ar;
	@Autowired
	private StudentApplyInformationRepository sair;
	@Autowired
	private AssistantRepository asr;
	@Autowired
	private OwnAssistantRepository oar;
	@Autowired
	private AssistantAllInformationRepository aar;
	
	
	@Override
	public Admin AdminLogin(int admin_id, int admin_password) {	
		return ar.findAdminById(admin_id, admin_password);
	}

	@Override
	public List<StudentApplyInformation> findAllStudentApplyIn() {
		return sair.findAllStudentApplyIn();
	}

	@Override
	public StudentApplyInformation findStudentApplyInforByStuid(int id) {
		return sair.findStudentApplyInforByStuid(id);
	}

	@Override
	public void FailedUpdateStudentApplyInformation(int id , String Comment) {									//拒绝申请助教信息
		sair.FailedUpdateComment(id, Comment);																	
	}

	@Override
	public void SuccessUpdateStudentApplyInformation(StudentApplyInformation studentApplyInformation) {			//接受申请助教信息
		sair.SuccessUpdateComment(studentApplyInformation.getS_id(),studentApplyInformation.getComment());		//更新填写报名表
		int id = asr.findMaxId()+1;
		studentApplyInformation.setAssist_id(id);																//更新报名表信息
		
		String name =  studentApplyInformation.getS_name();			
		asr.InsertAssistant(id, name, 123);																	 	//插入一条新的助教记录
		asr.InsertStudentAndAssistant(id,studentApplyInformation.getS_id());									//插入一条学生助教数据
		oar.InsertOwnAssistant(studentApplyInformation.getT_id(), id , studentApplyInformation.getC_id());		//插入助教从属表
	}
	
	@Override
	public List<AssistantAllInformation> FindAllAssistantInformation() {
		return aar.findAllAssistantInformation();
	}
	

}
