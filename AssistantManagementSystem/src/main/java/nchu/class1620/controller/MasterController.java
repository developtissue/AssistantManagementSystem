package nchu.class1620.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import nchu.class1620.service.*;

@Controller
public class MasterController {
	
	
	@Autowired
	private AssistantService assistantService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private TeacherService teacherService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		return "login";
	}
	
	@PostMapping("main")
	public String home(String id , String password ,String value, Model model , HttpSession session) {
		int ids = Integer.parseInt(id);
		int passwords = Integer.parseInt(password);
		int type = Integer.parseInt(value);
		
		if(type == 1) {
			if(studentService.StudentLogin(ids, passwords) != null) {
				System.out.println("Hello,Student");
				session.setAttribute("student",studentService.StudentLogin(ids, passwords));
				return "MainInterface";
			}else {
				return "login";
			}
		}else if(type == 2) {
			if(adminService.AdminLogin(ids, passwords) != null) {
				System.out.println("Hello,Admin");
				session.setAttribute("admin",adminService.AdminLogin(ids, passwords));
				return "MainInterface";
			}else {
				return "login";
			}
		}else if(type ==4) {
			if(teacherService.TeacherLogin(ids, passwords) != null) {
				System.out.println("Hello,Teacher");
				session.setAttribute("teacher",teacherService.TeacherLogin(ids, passwords));
				return "MainInterface";
			}else {
				return "login";
			}
		}else {
			if(assistantService.AssistantLogin(ids, passwords) != null) {
				System.out.println("Hello,Assistant");
				session.setAttribute("assistant",assistantService.AssistantLogin(ids, passwords));
				return "MainInterface";
			}else {			
				return "login";
			}
		}
	}
	
	@GetMapping("/CheckApplyTable")
	public String CheckApplyTable(Model model) {
		return "admin/CheckApplyTable";
	}
	
	@GetMapping("/CheckDetailTable")
	public String CheckDetailTable(Model model) {
		return "admin/CheckDetailTable";
	}
	
	@GetMapping("/ViewAssistant")
	public String ViewAssistant(Model model) {
		return "admin/ViewAssistant";
	}
	
	@GetMapping("/ModifyAssistantInformation")
	public String ModifyAssistantInfomation(Model model) {
		return "admin/ModifyAssistantInformation";
	}
	
	@GetMapping("/ViewRecruitment")
	public String ViewRecruitment(Model model) {
		return "student/ViewRecruitment";
	}
	
	@GetMapping("/WriteRecruitment")
	public String WriteRecruitment(Model model) {
		return "student/WriteRecruitment";
	}
	
	@GetMapping("/PostRecruitment")
	public String PostRecruitment(Model model) {
		return "teacher/PostRecruitment";
	}
	
	@GetMapping("/ViewTeacherDetailRecruitment")
	public String ViewTeacherDetailRecruitment(Model model) {
		return "student/ViewTeacherDetailRecruitment";
	}
	
	@GetMapping("/ViewPostRecruitment")
	public String ViewPostRecruitment(Model model) {
		return "teacher/ViewPostRecruitment";
	}
	
	@GetMapping("/ModifyPostRecruitment")
	public String ModifyPostRecruitment(Model model) {
		return "teacher/ModifyPostRecruitment";
	}
	
	
	@GetMapping("/Logout")
	public String Logout(Model model , HttpSession session) {	//移除session中的对象
		session.removeAttribute("teacher");
		session.removeAttribute("assistant");
		session.removeAttribute("admin");
		session.removeAttribute("student");
		return "login";
	}
	
	
}

