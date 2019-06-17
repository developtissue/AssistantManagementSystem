package nchu.class1620.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nchu.class1620.dto.MyEntity2;
import nchu.class1620.entity.DoTask;
import nchu.class1620.entity.Student;
import nchu.class1620.entity.Task;
import nchu.class1620.repository.DoTaskRepository;
import nchu.class1620.repository.StudentRepository;
import nchu.class1620.repository.TaskRepository;

/*
 * author: 16202125-吴俊雄
 * @Service层  
 *  MyService2类主要进行作业成绩方面的业务逻辑操作
 */

@Service
public class MyService2 {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private TaskRepository taskRepo;
	@Autowired
	private DoTaskRepository doTaskRepo;
	
	public List<MyEntity2> getMyEntity2List(Integer sid){
		List<MyEntity2> result = new ArrayList<>();
		List<DoTask> list = doTaskRepo.findByStuId(sid);
		
//		System.out.println("打印List<DoTask> list:");
//		for(DoTask dt : list) {
//			System.out.println(dt.getS_id());
//			System.out.println(dt.getTask_id());
//			System.out.println(dt.getTask_grade());
//		}
		
		for (DoTask dt : list) {
			MyEntity2 e = new MyEntity2();
			e.setS_id(sid);
			Student student = studentRepo.findById(sid);
			e.setS_name(student.getS_name());
			Task task = taskRepo.findById(dt.getT_id());
			e.setTask_name(task.getT_name());
			e.setTask_content(task.getT_content());
			e.setTask_grade(dt.getT_grade());
			result.add(e);
		}
		return result;
	}
	
	public List<MyEntity2> getMyEntity2List2(Integer clsid){
        List<MyEntity2> result = new ArrayList<>();
		List<Student> stuList = studentRepo.findByClsId(clsid);
		for(Student s : stuList) {
			List<DoTask> list = doTaskRepo.findByStuId(s.getS_id());
			for (DoTask dt : list) {
				MyEntity2 e = new MyEntity2();
				e.setS_id(s.getS_id());
				Student student = studentRepo.findById(s.getS_id());
				e.setS_name(student.getS_name());
				Task task = taskRepo.findById(dt.getT_id());
			    e.setTask_name(task.getT_name());
			    e.setTask_content(task.getT_content());
			    e.setTask_grade(dt.getT_grade());
				result.add(e);
			}
		}
		return result;
	}
	
}
