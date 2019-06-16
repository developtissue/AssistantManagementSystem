package nchu.class1620.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HanController {

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
		return "teacher/DisplayAssistantGrade";
	}

	@GetMapping("/WriteComment")
	public String WriteComment(Model model) {
		return "teacher/WriteComment";
	}
}
