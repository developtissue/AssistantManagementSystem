package nchu.class1620.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.processing.Filer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nchu.class1620.entity.Experiment;
import nchu.class1620.entity.Report;
import nchu.class1620.entity.Student;
import nchu.class1620.entity.Task;
import nchu.class1620.repository.ExperimentRepository;
import nchu.class1620.repository.StudentRepository;
import nchu.class1620.repository.TaskRepository;

/*
 * Created by ZhangJing
 * Notes:If you modify this class,you should keep attributes and methods
 *       which i have already done.But you can add what you want.
 * */
@Controller
public class ZhangController {
	@Autowired
	private ExperimentRepository experimentRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private TaskRepository taskRepo;
	/*
	 * I will use session to define this attribute
	 */
	private int assist_id = 1601;

	@PostMapping("/AssistantInitial")
	public String PostAssistantInitial(Model model) {
		/*
		 * Upload Experimet
		 */
		ArrayList<Experiment> experiments = (ArrayList<Experiment>) experimentRepo.findByAssitantId(assist_id);

		for (Experiment experiment : experiments) {
//			System.out.println(experiment.getE_id() + " " + experiment.getE_name() + " " + experiment.getE_content());
			experiment.setStudents(studentRepo.findExperimetByAssitantId(assist_id, experiment.getE_id()));
		}
		model.addAttribute("experiments", experiments);

		/*
		 * Upload Task
		 */
		ArrayList<Task> tasks = (ArrayList<Task>) taskRepo.findByAssitantId(assist_id);
		for (Task task : tasks) {
//			System.out.println(task.getT_id() + " " + task.getT_name() + " " + task.getT_content());
			task.setStudents(studentRepo.findTaskByAssitantId(assist_id, task.getT_id()));
		}
		model.addAttribute("tasks", tasks);
		return "assistant/AssistantInitial";
	}

	@GetMapping("/AssistantInitial")
	public String GetAssistantInitial(Model model) {
		return PostAssistantInitial(model);
	}

	@GetMapping("/CheckExperiment")
	public String CheckExperiment(@RequestParam(name = "e_id", required = true) int e_id,
			@RequestParam(name = "s_id", required = true) int s_id, Model model) {
		System.out.println("/CheckExperiment");
		model.addAttribute("title", taskRepo.findByTaskName(e_id));
		System.out.println(taskRepo.findByTaskName(e_id));
		File file = new File(this.getClass().getResource("").getPath());
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		String url = file.getPath() + "/src/main/resources/static/Experiment/1601/1/" + s_id + ".txt";
		System.out.println(url);
		file = new File(url);
		String text = "";
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				text = text + line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(text);
		model.addAttribute("content", text);
		return "assistant/CheckExperimentOrWork";
	}

	@GetMapping("/CheckTask")
	public String CheckTask(@RequestParam(name = "t_id", required = true) int t_id,
			@RequestParam(name = "s_id", required = true) int s_id, Model model) {
		System.out.println("check task");
		model.addAttribute("title", experimentRepo.findByExperimentName(t_id));
		System.out.println(experimentRepo.findByExperimentName(t_id));
		String text = "";
		File file = new File(this.getClass().getResource("").getPath());
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		file = file.getParentFile();
		String url = file.getPath() + "/src/main/resources/static/Task/1601/1/" + s_id + ".txt";
		System.out.println(url);
		file = new File(url);
		try (FileReader reader = new FileReader(file);
				BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				text += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(text);
		model.addAttribute("content", text);
		return "assistant/CheckExperimentOrWork";
	}

	@GetMapping("/ExperimentReport")
	public String ExperimentReport(@RequestParam(name = "class_id", required = true) int class_id, Model model) {
		ArrayList<Report> reports = experimentRepo.findExperiemntRportByClass(class_id);
		model.addAttribute("reports", reports);
		return "assistant/ExperimentOrWorkReport";
	}

	@GetMapping("/TaskReport")
	public String TaskReport(@RequestParam(name = "class_id", required = true) int class_id, Model model) {
		ArrayList<Report> reports = taskRepo.findTaskRportByClass(class_id);
		model.addAttribute("reports", reports);
		return "assistant/ExperimentOrWorkReport";
	}

	@PostMapping("/SubmitScore")
	public String SubmitScore(String score, String comment, Model model) {

		return "assistant/AssistantInitial";
	}
}
