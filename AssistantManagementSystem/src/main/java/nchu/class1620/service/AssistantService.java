package nchu.class1620.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nchu.class1620.entity.*;
import nchu.class1620.repository.AssistantRepository;
import nchu.class1620.repository.CourseRepository;

/*
 * 16202128
 * yuchao
 * 
 * 
 */



@Service
public class AssistantService implements AssistantServiceInterface{

	@Autowired
	private AssistantRepository loginRepository;
	
	@Override
	public Assistant AssistantLogin(int assist_id, int assist_password) {
		return loginRepository.findAssistantById(assist_id, assist_password);
	}
	
}
