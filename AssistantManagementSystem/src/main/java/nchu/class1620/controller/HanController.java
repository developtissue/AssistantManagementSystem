package nchu.class1620.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nchu.class1620.entity.OwnAssistant;
import nchu.class1620.repository.AssistantRepository;

@Controller
public class HanController {
	@Autowired
	private AssistantRepository AssistantRepo;
	
	
	@GetMapping("/ExperimentReport")
	public String ExperimentReport(Model model) {
		return "assistant/ExperimentReport";
	}
	
	@GetMapping("/WorkReport")
	public String WorkReport(Model model) {
		return "assistant/WorkReport";
	}
	
	@GetMapping("/QueryGrade")
	public String QuaryGrade(Model model) {
		return "student/QueryGrade";
	}
	
	@GetMapping("/ViewInformation")
	public String ViewInformation(Model model) {
		return "student/ViewInformation";
	}
	
	@GetMapping("/ViewComment")
	public String ViewComment(Model model) {
		return "student/ViewComment";
	}
	
	@GetMapping("/DisplayAssistantGrade")
	public String DisplayAssistant(Model model) {
		List<OwnAssistant> oa= AssistantRepo.findAll();
		model.addAttribute("oa",oa);
		return "teacher/DisplayAssistantGrade";
	}
	
	@GetMapping("/WriteComment")
	public String WriteComment(Model model) {
		return "teacher/WriteComment";
	}
}
