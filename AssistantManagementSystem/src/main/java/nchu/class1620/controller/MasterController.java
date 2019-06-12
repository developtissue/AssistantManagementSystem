package nchu.class1620.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterController {
	
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
	
}

