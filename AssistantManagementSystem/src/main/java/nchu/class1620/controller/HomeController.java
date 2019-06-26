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
 * author: 16202125-�⿡��
 * HomeController ��������
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
	 * ����ǰ�ڿ�������
	 * ��1����¼����Ĳ���
	 * ��2����ҳ����ת �Ĳ���
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
     * ��ҳ����չʾ
     * ѧ�� ʵ�� / ��ҵ �ɼ���Ϣ�ı��� Controller
     * �ڷ�����Ӧ���� "������ʽ" 
     * ���û���������ݣ����зǷ����ݵ���֤
     */
	@GetMapping("/table")
	public String displayGradeTable(Model model,String clsid,String clsid2,
			String sid,String sid2,String clsid3,String clsid4) {
		
		//ͨ���༶�Ų�ѯʵ��ɼ�
		if(clsid == null || clsid == "") {
			//model.addAttribute("s_grades_list", ms1.getMyEntity1List2(0));
		}else {
			/*
			 * String str="��Ҫ�жϵ��ַ���"
			 * //�����жϾ�ȷ�ж���������С��
			 * ����(1)str.matches("^[-+]?(([0-9]+)(.)?|(.)?)$");
			 * ����(2)str.matches("\\d+");
			 * ������� !str.matches("\\d+") ����if����while���������ж�
			 */
			String str = clsid;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("�����clsid���Ǵ�����");
			}else {
				cls_id = Integer.parseInt(clsid);
			}
			model.addAttribute("s_grades_list", ms1.getMyEntity1List2(cls_id));
		}
		
		//ͨ��ѧ�Ų�ѯʵ��ɼ�
		if(sid == null || sid == "") {
			//model.addAttribute("s_grades3_list", ms1.getMyEntity1List3(0));
		}else {
			String str = sid;
			int s_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("�����sid���Ǵ�����");
			}else {
				s_id = Integer.parseInt(sid);
			}
			model.addAttribute("s_grades3_list", ms1.getMyEntity1List3(s_id));
		}
		
		//ͨ���༶�Ų�ѯ��ҵ�ɼ�
		if(clsid2 == null || clsid2 == "") {
			//model.addAttribute("s_grades_list", ms1.getMyEntity2List2(0));
		}else {
			String str = clsid2;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("�����clsid2���Ǵ�����");
			}else {
				cls_id = Integer.parseInt(clsid2);
			}
			model.addAttribute("s_taskGrades_list2", ms2.getMyEntity2List2(cls_id));
		}
		
		//ͨ��ѧ�Ų�ѯ��ҵ�ɼ�
		if(sid2 == null || sid2 == "") {
			//model.addAttribute("s_taskGrades_list", ms2.getMyEntity2List(0));
		}else {
			String str = sid2;
			int s_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("�����sid2���Ǵ�����");
			}else {
				s_id = Integer.parseInt(sid2);
			}
			model.addAttribute("s_taskGrades_list", ms2.getMyEntity2List(s_id));
		}
		
		//ͨ���༶�Ų�ѯ����ѧ��������ʵ���ƽ���ɼ�
		if(clsid3 == null || clsid3 == "") {
		}else {
			String str = clsid3;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("�����clsid3���Ǵ�����");
			}else {
				cls_id = Integer.parseInt(clsid3);
			}
			model.addAttribute("s_avgGrades_list", ms3.getMyEntity3List(cls_id));
		}
		
		//ͨ���༶�Ų�ѯ����ѧ����������ҵ��ƽ���ɼ�
		if(clsid4 == null || clsid4 == "") {
		}else {
			String str = clsid4;
			int cls_id = 0;
			if( !str.matches("\\d+") ) {
				System.out.println("�����clsid4���Ǵ�����");
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
		map1.put("stuName", "ʵ��");
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
		map2.put("stuName2", "��ҵ");
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
		 * ͨ��ʹ���ַ����Ľ�ȡ��ȡ�Ӵ��ķ���
		 * substring(begin,end)��ȡ�Ӵ�
		 * ���������ѧ��id��Ž��н�ȡ��ȡ��༶���
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
				//����ƽ���ֵĴ���
			}else {
//				counts[1]++;
//				//δ����ƽ���ֵĴ���
			}
		}
		//δ����ƽ���ֵĴ���
		counts[1] = result.size() - counts[0];
		if(counts[1] == 0) {
			//���counts[1]��ֵΪ0�Ļ���Ϊ����ʾЧ���ȽϺ�
			//Ϊcounts[1]���³�ʦ������ֵΪ1
			counts[1] = 1;
		}
		
		map.put("counts", counts);
		String[] imple = {"����ƽ���ֵĴ���","δ����ƽ���ֵĴ���"};
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
		 * ����һ�� int ���͵����� ,��ʼ��������Ĭ��ֵ��Ϊ1
		 * ����������Ͱ�����˼��
		 * counts[0] ����60�����µĳɼ�����
		 * counts[1] ����60��70�ֵĳɼ�����
		 * counts[2] ����70��80�ֵĳɼ�����
		 * counts[3] ����80��90�ֵĳɼ�����
		 * counts[4] ����90��100�����ϵĳɼ�����
		 * counts[5] �������100�ֵĳɼ�����
		 */
		int counts[] = {1,1,1,1,1,1};
		
		for(int i=0;i<result.size();i++) {
			
			taskName[i] = result.get(i).getTask_name();
			System.out.println("taskName[i] " + taskName[i] );
			
			if(result.get(i).getTask_grade() < 60) {
				counts[0]++;
				taskName[i] = "��ҵ�ɼ�����60��";
			}else if(result.get(i).getTask_grade() >=60 
					 || result.get(i).getTask_grade() < 70) {
				counts[1]++;
				taskName[i] = "��ҵ�ɼ�Ϊ60~70��";
			}else if(result.get(i).getTask_grade() >=70 
					 || result.get(i).getTask_grade() < 80) {
				counts[2]++;
				taskName[i] = "��ҵ�ɼ�Ϊ70~80��";
			}else if(result.get(i).getTask_grade() >=80 
					 || result.get(i).getTask_grade() < 90) {
				counts[3]++;
				taskName[i] = "��ҵ�ɼ�Ϊ80~90��";
			}else if(result.get(i).getTask_grade() >=90 
					 || result.get(i).getTask_grade() < 100) {
				counts[4]++;
				taskName[i] = "��ҵ�ɼ�Ϊ90~100��";
			}else {
				counts[5]++;
				taskName[i] = "��ҵ�ɼ�Ϊ100������";
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