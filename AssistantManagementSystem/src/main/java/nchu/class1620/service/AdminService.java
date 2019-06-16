package nchu.class1620.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nchu.class1620.entity.Admin;
import nchu.class1620.repository.AdminRepository;

/*
 * 16202128 ”‡≥¨
 * 
 */
@Service
public class AdminService implements AdminServiceInterface{

	@Autowired
	private AdminRepository ar;
	
	@Override
	public Admin AdminLogin(int admin_id, int admin_password) {	
		return ar.findAdminById(admin_id, admin_password);
	}

}
