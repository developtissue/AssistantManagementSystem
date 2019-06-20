package nchu.class1620.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import nchu.class1620.dto.MyEntity4;
import nchu.class1620.entity.DoTask;
import nchu.class1620.entity.OwnAssistant;
import nchu.class1620.entity.Student;
import nchu.class1620.entity.Teacher;
import nchu.class1620.repository.DoTaskRepository;
import nchu.class1620.repository.OwnAssistantRepository;
import nchu.class1620.repository.TeacherRepository;

@Controller
public class HanController {

	@Autowired
	private OwnAssistantRepository OwnAssistRepo;
	@Autowired
	private TeacherRepository TeacherRepo;
	@Autowired
	private DoTaskRepository dotaskRepo;
	
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
	public String DisplayAssistant(Model model, HttpSession session) {
		Teacher t = (Teacher) session.getAttribute("teacher");
		int t_id = t.getId();
		System.out.println(t_id);
		System.out.println("1111111111111111111");
		List<MyEntity4> oa = OwnAssistRepo.findByTid(t_id);
		model.addAttribute("oa", oa);
		return "teacher/DisplayAssistantGrade";
	}

	@GetMapping("/WriteComment")
	public String WriteComment(Model model) {
		Teacher t = TeacherRepo.findTeacher();
		model.addAttribute("t", t);
		return "teacher/WriteComment";
	}

	@PostMapping("/SubmitGradeAndComment")
	public String SubmitGradeAndComment(Model model,int t_id,int Assistid,int c_id,double AssistGrade,String comment) {
		System.out.println(t_id);
		System.out.println(Assistid);
		System.out.println(c_id);
		System.out.println(AssistGrade);
		System.out.println(comment);
		OwnAssistRepo.UpdateGradeAndMessage(t_id,Assistid,c_id,AssistGrade,comment);
		/* model.addAttribute("oa", oa); */
		List<MyEntity4> oa = OwnAssistRepo.findByTid(t_id);
		model.addAttribute("oa", oa);
		return "teacher/DisplayAssistantGrade"; 
	}

}
