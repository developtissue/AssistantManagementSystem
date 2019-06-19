package nchu.class1620.controller;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nchu.class1620.dto.AssistantAllInformation;
import nchu.class1620.dto.StudentApplyInformation;
import nchu.class1620.entity.Teacher;
import nchu.class1620.repository.StudentApplyInformationRepository;
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
	public String home(String id, String password, String value, Model model, HttpSession session) { // 登录控制器
		int ids = Integer.parseInt(id);
		int passwords = Integer.parseInt(password);
		int type = Integer.parseInt(value);

		if (type == 1) {
			if (studentService.StudentLogin(ids, passwords) != null) {
				System.out.println("Hello,Student");
				session.setAttribute("student", studentService.StudentLogin(ids, passwords));
				return "MainInterface";
			} else {
				return "login";
			}
		} else if (type == 2) {
			if (adminService.AdminLogin(ids, passwords) != null) {
				System.out.println("Hello,Admin");
				session.setAttribute("admin", adminService.AdminLogin(ids, passwords));
				return "MainInterface";
			} else {
				return "login";
			}
		} else if (type == 4) {
			if (teacherService.TeacherLogin(ids, passwords) != null) {
				System.out.println("Hello,Teacher");
				session.setAttribute("teacher", teacherService.TeacherLogin(ids, passwords));
				return "MainInterface";
			} else {
				return "login";
			}
		} else {
			if (assistantService.AssistantLogin(ids, passwords) != null) {
				System.out.println("Hello,Assistant");
				session.setAttribute("assistant", assistantService.AssistantLogin(ids, passwords));
				return "MainInterface";
			} else {
				return "login";
			}
		}
	}

	@GetMapping("/CheckApplyTable")
	public String CheckApplyTable(Model model) {
		List<StudentApplyInformation> list = adminService.findAllStudentApplyIn();
		model.addAttribute("list", list);

		return "admin/CheckApplyTable";
	}

	@GetMapping("/CheckDetailTable/{id}")
	public String CheckDetailTable(Model model, @PathVariable Integer id) {
		StudentApplyInformation studentApplyInformation = adminService.findStudentApplyInforByStuid(id);
		System.out.println(id);

		model.addAttribute("studentApplyInformation", studentApplyInformation);

		return "admin/CheckDetailTable";
	}

	@GetMapping("/ViewAssistant")
	public String ViewAssistant(Model model) {
		List<AssistantAllInformation> list = adminService.FindAllAssistantInformation();
		model.addAttribute("list", list);

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
	public String PostRecruitment(Model model, HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		model.addAttribute("teacher", teacher);
		Integer first = (Integer) session.getAttribute("first");
		if (first != null)
			session.setAttribute("first", first + 1);
		return "teacher/PostRecruitment";
	}

	@ResponseBody
	@PostMapping("/Post/{require}/{c_name}")
	public String Post(Model model, @PathVariable String require, @PathVariable String c_name, HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		Boolean flags = teacherService.InsertPublishRecruitment(teacher, c_name, require);
		session.setAttribute("flag", flags);
		session.setAttribute("first", 0);
		return "123";
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

	@GetMapping("/Logout") // 退出登录
	public String Logout(Model model, HttpSession session) { // 移除session中的对象
		session.removeAttribute("teacher");
		session.removeAttribute("assistant");
		session.removeAttribute("admin");
		session.removeAttribute("student");
		session.removeAttribute("flag");
		return "login";
	}

	@PostMapping("/ModifyComment/{type}/{id}/{comment}")
	public String Modify(Model model, @PathVariable Integer type, @PathVariable Integer id,
			@PathVariable String comment) { // 更新助教操作
		StudentApplyInformation studentApplyInformation = adminService.findStudentApplyInforByStuid(id);
		studentApplyInformation.setComment(comment);

		if (type == 1) {
			adminService.SuccessUpdateStudentApplyInformation(studentApplyInformation);
			System.out.println("录用成功！");
		} else {
			adminService.FailedUpdateStudentApplyInformation(studentApplyInformation.getS_id(), comment);
			System.out.println("更新成功！");
		}

		return "admin/CheckApplyTable";
	}

}
