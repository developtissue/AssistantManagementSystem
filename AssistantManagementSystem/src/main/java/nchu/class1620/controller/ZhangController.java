package nchu.class1620.controller;

import java.io.BufferedReader;
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
import nchu.class1620.repository.ExperimentRepository;
import nchu.class1620.repository.StudentRepository;

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

	@PostMapping("/AssistantInitial")
	public String PostAssistantInitial(@RequestParam(name = "assist_id", required = true) int assist_id, Model model) {
		// System.out.println(assist_id);
		ArrayList<Experiment> experiments = (ArrayList<Experiment>) experimentRepo.findByAssitantId(assist_id);
//		System.out.println(experiments.size());
		for (Experiment experiment : experiments) {
//			System.out.println(experiment.getE_name()+" "+experiment.getE_content());
			experiment.setStudents((studentRepo.findExperimetByAssitantId(assist_id)));
		}
		model.addAttribute("experiments", experiments);
//        System.out.println(experiments.size());
		return "assistant/AssistantInitial";
	}

	@GetMapping("/AssistantInitial")
	public String GetAssistantInitial(@RequestParam(name = "assist_id", required = true) int assist_id, Model model) {
		return PostAssistantInitial(assist_id, model);
	}

	@GetMapping("/CheckExperimentOrWork")
	public String CheckExperimentOrWork(@RequestParam(name = "e_id", required = true) int e_id,
			@RequestParam(name = "s_id", required = true) int s_id, Model model) {
		model.addAttribute("title", experimentRepo.findByExperimentName(e_id));
		String text = "";
		try (FileReader reader = new FileReader("Experiment/" + e_id + "/" + s_id + ".txt");
				BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				text += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("content", text);
		return "assistant/CheckExperimentOrWork";
	}

	@GetMapping("/ExperimentOrWorkReport")
	public String ExperimentOrWorkReport(Model model) {
		return "assistant/ExperimentOrWorkReport";
	}

}
