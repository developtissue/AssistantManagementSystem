package nchu.class1620.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nchu.class1620.entity.DoTask;
import nchu.class1620.entity.OwnAssistant;
import nchu.class1620.entity.Student;
import nchu.class1620.entity.Teacher;
import nchu.class1620.repository.AssistantRepository;
import nchu.class1620.repository.DotaskRepository;
import nchu.class1620.repository.OwnAssistantRepository;
import nchu.class1620.repository.TeacherRepository;

@Controller
public class HanController {

	@Autowired
	private AssistantRepository AssistantRepo;
	@Autowired
	private OwnAssistantRepository OwnAssistRepo;
	@Autowired
	private TeacherRepository TeacherRepo;
	@Autowired
	private DotaskRepository dotaskRepo;
	
	
	@GetMapping("/QueryGrade")
	public String QuaryGrade(Model model, HttpSession session) {
		Student s = (Student) session.getAttribute("student");
		int s_id = s.getS_id();
		System.out.println(s_id);
		DoTask dotask = dotaskRepo.findById(s_id);
		model.addAttribute("dotask", dotask);
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
		Teacher t = TeacherRepo.findTeacher();
	    model.addAttribute("t",t);
		return "teacher/WriteComment";
	}
	
	@PostMapping("/SubmitGradeAndComment")
	public String SubmitGradeAndComment(Model model,@RequestParam(name = "t_id", required = true)int t_id,@RequestParam(name = "Assistid", required = true)int Assistid,@RequestParam(name = "AssistGrade", required = true)double AssistGrade,@RequestParam(name = "message", required = true)String message ) {
		/*
		 * OwnAssistant oa= OwnAssistRepo.InsertAll(t_id,Assistid,AssistGrade,message);
		 * model.addAttribute("oa", oa);
		 */
		return "teacher/DisplayAssistantGrade";
	}
	
	
}
