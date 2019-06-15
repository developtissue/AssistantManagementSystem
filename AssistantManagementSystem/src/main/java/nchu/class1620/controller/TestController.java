package nchu.class1620.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import nchu.class1620.dto.MyEntity1;
import nchu.class1620.service.MyService1;

@Controller
public class TestController {
	
//	@Autowired
//	private MyService1 ms1;
//	
//	@ResponseBody
//	@GetMapping("/test")
//	public Map<String, Object> test() {
//		Map<String, Object> map = new HashMap<>();
//		map.put("name", "wjx");
//		//map.put("garde", Arrays.asList(90,100,79));
//		
//		List<MyEntity1> result = ms1.getMyEntity1List(1620****);
//		double[] grades = new double[result.size()];
//		for(int i = 0; i < result.size() ; i++) {
//			grades[i] = result.get(i).getAe_grade();
//		}
//		map.put("garde", grades);
//		
//		return map;
//	}
//	
//	@GetMapping("/t")
//	public String testt() {
//		return "test";
//	}
	
	
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
