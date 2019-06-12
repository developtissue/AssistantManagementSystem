package nchu.class1620.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import nchu.class1620.dto.MyEntity1;
import nchu.class1620.service.MyService1;

@Controller
public class HomeController {
	
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
	public String displayGradeTable(Model model,String clsid,String sid) {
		
		if(clsid == null || clsid == "") {
			model.addAttribute("s_grades_list", ms1.getMyEntity1List2(0));
		}else {
			int cls_id = Integer.parseInt(clsid);
			model.addAttribute("s_grades_list", ms1.getMyEntity1List2(cls_id));
		}
		
		if(sid == null || sid == "") {
			model.addAttribute("s_grades3_list", ms1.getMyEntity1List3(0));
		}else {
			int s_id = Integer.parseInt(sid);
			model.addAttribute("s_grades3_list", ms1.getMyEntity1List3(s_id));
		}
		
		return "teacher/DisplayTable";
	}
	
	@GetMapping("/chart")
	public String analysisGradeChart(Model model) {
		return "teacher/AnalyzeGrade";
	}
	
	@ResponseBody
	@GetMapping("/test")
	public Map<String, Object> test() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "wjx");
		//map.put("garde", Arrays.asList(90,100,79));
		
		List<MyEntity1> result = ms1.getMyEntity1List(16202101);
		
		double[] grades = new double[result.size()];
		String[] eName = new String[result.size()];
		String[] stuName = new String[result.size()];
//		String[] cName = new String[result.size()];
		
		for(int i = 0; i < result.size() ; i++) {
			grades[i] = result.get(i).getAe_grade();
			stuName[i] = result.get(i).getS_name();
			eName[i] = result.get(i).getE_name();
//			cName[i] = result.get(i).getC_name();
		}
		
		map.put("garde", grades);
		map.put("stuName", result.get(0).getS_name());
		map.put("eName", eName);
//		for(String en : eName) {
//			System.out.println(en);
//		}
		return map;
	}
	
	@GetMapping("/t")
	public String testt() {
		return "test";
	}
	
}