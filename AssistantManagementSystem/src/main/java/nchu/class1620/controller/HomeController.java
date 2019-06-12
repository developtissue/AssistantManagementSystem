package nchu.class1620.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nchu.class1620.repository.QueryRepository;
import nchu.class1620.service.MyService1;

@Controller
public class HomeController {

	@Autowired
	private QueryRepository qr;
	
	@Autowired
	private MyService1 ms1;
	
	@GetMapping("/")
	public String index(Model model) {
		return "login";
	}
	
	@GetMapping("main")
	public String home(Model model) {
		return "MainInterface";
	}
	
	@GetMapping("/table")
	public String displayGradeTable(Model model) {
		return "teacher/DisplayTable";
	}
	
	@GetMapping("/chart")
	public String analysisGradeChart(Model model) {
		return "teacher/AnalyzeGrade";
	}
	
//	@GetMapping("/login")
//	public String login(Model model) {
//		return "plain_page";
//	}
//	
//	@GetMapping("/testTable")
//	public String testTable(Model model) {
//		model.addAttribute("s_grades_list", qr.findAll());
//		return "plain_page";
//	}
	
}
