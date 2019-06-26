package nchu.class1620.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import nchu.class1620.dto.MyEntity1;
import nchu.class1620.dto.MyEntity2;
import nchu.class1620.dto.MyEntity3;
import nchu.class1620.service.MyService1;
import nchu.class1620.service.MyService2;
import nchu.class1620.service.MyService3;
import nchu.class1620.service.MyService4;

/*
 * author: 16202125-吴俊雄
 * HomeController 控制器类
 */

@Controller
public class HomeController {
	
	@Autowired
	private MyService1 ms1;
	@Autowired
	private MyService2 ms2;
	@Autowired
	private MyService3 ms3;
	@Autowired
	private MyService4 ms4;
	
	
	/*
	 * 用于前期开发测试
	 * （1）登录界面的测试
	 * （2）主页面跳转 的测试
	 */
//	@GetMapping("/")
//	public String index(Model model) {
//		return "login";
//	}
//	
//	@GetMapping("main")
//	public String home(Model model) {
//		return "MainInterface";
//	}
	
	
    /*
     * 在页面上展示
     * 学生 实验 / 作业 成绩信息的报表 Controller
     * 在方法中应用了 "正则表达式" 
     * 对用户输入的数据，进行非法数据的验证
     */
	@GetMapping("/table")
	public String displayGradeTable(Model model,String clsid,String clsid2,
			String sid,String sid2,String clsid3,String clsid4) {
		
		//通过班级号查询实验成绩
		if(clsid == null || clsid == "") {
			//model.addAttribute("s_grades_list", ms1.getMyEntity1List2(0));
		}else {
			/*
			 * String str="你要判断的字符串"
			 * //可以判断精确判断整数或者小数
			 * 方法(1)str.matches("^[-+]?(([0-9]+)(.)?|(.)?)$");
			 * 方法(2)str.matches("\\d+");
			 * 将该语句 !str.matches("\\d+") 放入if或者while进行条件判断
			 */
			String str = clsid;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("输入的clsid不是纯数字");
			}else {
				cls_id = Integer.parseInt(clsid);
			}
			model.addAttribute("s_grades_list", ms1.getMyEntity1List2(cls_id));
		}
		
		//通过学号查询实验成绩
		if(sid == null || sid == "") {
			//model.addAttribute("s_grades3_list", ms1.getMyEntity1List3(0));
		}else {
			String str = sid;
			int s_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("输入的sid不是纯数字");
			}else {
				s_id = Integer.parseInt(sid);
			}
			model.addAttribute("s_grades3_list", ms1.getMyEntity1List3(s_id));
		}
		
		//通过班级号查询作业成绩
		if(clsid2 == null || clsid2 == "") {
			//model.addAttribute("s_grades_list", ms1.getMyEntity2List2(0));
		}else {
			String str = clsid2;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("输入的clsid2不是纯数字");
			}else {
				cls_id = Integer.parseInt(clsid2);
			}
			model.addAttribute("s_taskGrades_list2", ms2.getMyEntity2List2(cls_id));
		}
		
		//通过学号查询作业成绩
		if(sid2 == null || sid2 == "") {
			//model.addAttribute("s_taskGrades_list", ms2.getMyEntity2List(0));
		}else {
			String str = sid2;
			int s_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("输入的sid2不是纯数字");
			}else {
				s_id = Integer.parseInt(sid2);
			}
			model.addAttribute("s_taskGrades_list", ms2.getMyEntity2List(s_id));
		}
		
		//通过班级号查询各个学生的所有实验的平均成绩
		if(clsid3 == null || clsid3 == "") {
		}else {
			String str = clsid3;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("输入的clsid3不是纯数字");
			}else {
				cls_id = Integer.parseInt(clsid3);
			}
			model.addAttribute("s_avgGrades_list", ms3.getMyEntity3List(cls_id));
		}
		
		//通过班级号查询各个学生的所有作业的平均成绩
		if(clsid4 == null || clsid4 == "") {
		}else {
			String str = clsid4;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("输入的clsid4不是纯数字");
			}else {
				cls_id = Integer.parseInt(clsid4);
			}
			model.addAttribute("s_avgGrades_list2", ms4.getMyEntity3List(cls_id));
		}
		
		return "teacher/DisplayTable";
	}
	
	@GetMapping("/chart")
	public String analysisGradeChart(Model model) {
		return "teacher/AnalyzeGrade";
	}
	
	@ResponseBody
	@GetMapping("/test/{id}")
	public Map<String, Object> test(@PathVariable ("id") int id) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "wjx");
		
		List<MyEntity1> result = ms1.getMyEntity1List(id);
		
		double[] grades = new double[result.size()];
		String[] eName = new String[result.size()];
		String[] stuName = new String[result.size()];
		
		for(int i = 0; i < result.size() ; i++) {
			grades[i] = result.get(i).getAe_grade();
			stuName[i] = result.get(i).getS_name();
			eName[i] = result.get(i).getE_name();
		}
		
		map.put("garde", grades);
		map.put("stuName", result.get(0).getS_name());
		map.put("eName", eName);

		return map;
	}
	
//	@GetMapping("/t")
//	public String testt() {
//		return "test";
//	}
	
	@ResponseBody
	@GetMapping("/test2/{id}")
	public Map<String, Map<String, Object>> test2(@PathVariable ("id") int id) {
	
		Map<String, Map<String, Object>> mainMap = 
				     new HashMap<String, Map<String, Object>>();
		
		Map<String, Object> map1 = new HashMap<>();
		List<MyEntity3> result = ms3.getMyEntity3List(id);
		double[] grades = new double[result.size()];
		int[] stuid = new int[result.size()];
		String[] stuName = new String[result.size()];
		for(int i = 0; i < result.size() ; i++) {
			stuid[i] = result.get(i).getS_id();
			stuName[i] = result.get(i).getS_name();
			grades[i] = result.get(i).getAvgGrade();
		}
		map1.put("garde", grades);
		map1.put("stuName", "实验");
		map1.put("stuid", stuName);
		
		Map<String, Object> map2 = new HashMap<>();
		List<MyEntity3> result2 = ms4.getMyEntity3List(id);
		double[] grades2 = new double[result.size()];
		int[] stuid2 = new int[result.size()];
		String[] stuName2 = new String[result.size()];
		for(int i = 0; i < result2.size() ; i++) {
			stuid2[i] = result2.get(i).getS_id();
			stuName2[i] = result2.get(i).getS_name();
			grades2[i] = result2.get(i).getAvgGrade();
		}
		map2.put("garde2", grades2);
		map2.put("stuName2", "作业");
		map2.put("stuid2", stuName2);
		
		mainMap.put("map1", map1);
		mainMap.put("map2", map2);
		return mainMap;
	}
	
	@ResponseBody
	@GetMapping("/test3/{id}")
	public Map<String, Object> test3(@PathVariable ("id") int id) {
		Map<String, Object> map = new HashMap<>();
		
		List<MyEntity1> result = ms1.getMyEntity1List(id);
		String[] ename = new String[result.size()];
		for(int i=0;i<result.size();i++) {
			ename[i] = result.get(i).getE_content();
			System.out.println("ename[i] " + ename[i] );
		}
		
		/*
		 * id=16202101 
		 * s_id=162021 
		 * string_id=16202101-
		 * 通过使用字符串的截取获取子串的方法
		 * substring(begin,end)获取子串
		 * 将所传入的学生id编号进行截取获取其班级编号
		 */
		String string_id = id + "-";
		int s_id = Integer.parseInt(string_id.substring(0, 6));
		System.out.println("string_id.substring(0, 5): " + s_id);
		
		List<MyEntity3> me = ms3.getMyEntity3List(s_id);
		System.out.println(me.size());
		int[] counts = new int[2];
		double avg = 0;
		
		for(int i=0;i<me.size();i++) {
			if(me.get(i).getS_id() == id) {
				avg = me.get(i).getAvgGrade();
				break;
			}
		}
		System.out.println("avg" + avg);
		
		for(int i=0;i<result.size();i++) {
			if(avg <= result.get(i).getAe_grade()) {
				counts[0]++;
				//超过平均分的次数
			}else {
//				counts[1]++;
//				//未超过平均分的次数
			}
		}
		//未超过平均分的次数
		counts[1] = result.size() - counts[0];
		if(counts[1] == 0) {
			//如果counts[1]的值为0的话，为了显示效果比较好
			//为counts[1]重新厨师胡设置值为1
			counts[1] = 1;
		}
		
		map.put("counts", counts);
		String[] imple = {"超过平均分的次数","未超过平均分的次数"};
		map.put("ename", imple);
		
		return map;
	}
	
	@ResponseBody
	@GetMapping("/test4/{id}")
	public Map<String, Object> test4(@PathVariable ("id") int id) {
		Map<String, Object> map = new HashMap<>();
		
		List<MyEntity2> result = ms2.getMyEntity2List(id);
		String[] taskName = new String[result.size()];
		
		/*
		 * 定义一个 int 类型的数组 ,初始化设置其默认值都为1
		 * 采用类似于桶排序的思想
		 * counts[0] 代表60分以下的成绩次数
		 * counts[1] 代表60至70分的成绩次数
		 * counts[2] 代表70至80分的成绩次数
		 * counts[3] 代表80至90分的成绩次数
		 * counts[4] 代表90中100分以上的成绩次数
		 * counts[5] 代表等于100分的成绩次数
		 */
		int counts[] = {1,1,1,1,1,1};
		
		for(int i=0;i<result.size();i++) {
			
			taskName[i] = result.get(i).getTask_name();
			System.out.println("taskName[i] " + taskName[i] );
			
			if(result.get(i).getTask_grade() < 60) {
				counts[0]++;
				taskName[i] = "作业成绩低于60分";
			}else if(result.get(i).getTask_grade() >=60 
					 || result.get(i).getTask_grade() < 70) {
				counts[1]++;
				taskName[i] = "作业成绩为60~70分";
			}else if(result.get(i).getTask_grade() >=70 
					 || result.get(i).getTask_grade() < 80) {
				counts[2]++;
				taskName[i] = "作业成绩为70~80分";
			}else if(result.get(i).getTask_grade() >=80 
					 || result.get(i).getTask_grade() < 90) {
				counts[3]++;
				taskName[i] = "作业成绩为80~90分";
			}else if(result.get(i).getTask_grade() >=90 
					 || result.get(i).getTask_grade() < 100) {
				counts[4]++;
				taskName[i] = "作业成绩为90~100分";
			}else {
				counts[5]++;
				taskName[i] = "作业成绩为100分满分";
			}
		}
		
		map.put("counts", counts);
		map.put("taskName", taskName);
		
		return map;
	}
	
	
	
//	@ResponseBody
//	@GetMapping("/test2/{id}")
//	public Map<String, Map<String, Object>> test2(@PathVariable ("id") int id) {
//	
//		Map<String, Map<String, Object>> mainMap = 
//				     new HashMap<String, Map<String, Object>>();
//		
//		Map<String, Object> map1 = new HashMap<>();
//		List<MyEntity1> result = ms1.getMyEntity1List(16202101);
//		//List<MyEntity1> result = ms1.getMyEntity1List2(id);
//		
//		double[] grades = new double[result.size()];
//		String[] eName = new String[result.size()];
//		String[] stuName = new String[result.size()];
//		for(int i = 0; i < result.size() ; i++) {
//			grades[i] = result.get(i).getAe_grade();
//			stuName[i] = result.get(i).getS_name();
//			eName[i] = result.get(i).getE_name();
//		}
//		map1.put("garde", grades);
//		map1.put("stuName", result.get(0).getS_name());
//		map1.put("eName", eName);
//		
//		Map<String, Object> map2 = new HashMap<>();
//		List<MyEntity1> result2 = ms1.getMyEntity1List(16202102);
//		//List<MyEntity1> result2 = ms1.getMyEntity1List2(id);
//		
//		double[] grades2 = new double[result.size()];
//		String[] eName2 = new String[result.size()];
//		String[] stuName2 = new String[result.size()];
//		for(int i = 0; i < result2.size() ; i++) {
//			grades2[i] = result2.get(i).getAe_grade();
//			stuName2[i] = result2.get(i).getS_name();
//			eName2[i] = result2.get(i).getE_name();
//		}
//		map2.put("garde2", grades2);
//		map2.put("stuName2", result2.get(0).getS_name());
//		map2.put("eName2", eName2);
//		
//		/*
//		 * for(String en2 : eName2) { System.out.println(en2); }
//		 */
//		mainMap.put("map1", map1);
//		mainMap.put("map2", map2);
//		return mainMap;
//	}
	
}