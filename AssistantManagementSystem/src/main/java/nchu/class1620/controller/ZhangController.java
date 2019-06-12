package nchu.class1620.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nchu.class1620.repository.QueryRepository;
import nchu.class1620.service.MyService1;

@Controller
public class ZhangController {

	@GetMapping("/AssistantInitial")
	public String AssistantInitial(Model model) {
		return "assistant/AssistantInitial";
	}
	
	@GetMapping("/CheckExperimentOrWork")
	public String CheckExperimentOrWork(Model model) {
		return "assistant/CheckExperimentOrWork";
	}
	
	@GetMapping("/ExperimentOrWorkReport")
	public String ExperimentOrWorkReport(Model model) {
		return "assistant/ExperimentOrWorkReport";
	}
	
}

