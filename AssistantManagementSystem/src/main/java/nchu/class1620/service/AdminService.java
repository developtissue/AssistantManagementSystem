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
 * 16202128 �೬
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
	public void FailedUpdateStudentApplyInformation(int id , String Comment) {									//�ܾ�����������Ϣ
		sair.FailedUpdateComment(id, Comment);																	
	}

	@Override
	public void SuccessUpdateStudentApplyInformation(StudentApplyInformation studentApplyInformation) {			//��������������Ϣ
		sair.SuccessUpdateComment(studentApplyInformation.getS_id(),studentApplyInformation.getComment());		//������д������
		int id = asr.findMaxId()+1;
		studentApplyInformation.setAssist_id(id);																//���±�������Ϣ
		
		String name =  studentApplyInformation.getS_name();			
		asr.InsertAssistant(id, name, 123);																	 	//����һ���µ����̼�¼
		asr.InsertStudentAndAssistant(id,studentApplyInformation.getS_id());									//����һ��ѧ����������
		oar.InsertOwnAssistant(studentApplyInformation.getT_id(), id , studentApplyInformation.getC_id());		//�������̴�����
	}
	
	@Override
	public List<AssistantAllInformation> FindAllAssistantInformation() {
		return aar.findAllAssistantInformation();
	}
	

}
