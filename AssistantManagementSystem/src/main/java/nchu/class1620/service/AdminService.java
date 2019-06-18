package nchu.class1620.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nchu.class1620.dto.StudentApplyInformation;
import nchu.class1620.entity.Admin;
import nchu.class1620.repository.AdminRepository;
import nchu.class1620.repository.AssistantRepository;
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
	public void UpdateStudentApplyInformation(String Comment) {
//		int id = asr.findMaxId() + 1;
//		
//		asr.		//�����������ݿ�
//		asr.		//��1��������ݿ�
//		asr.  		//����¼ȡ״̬
	}

}
