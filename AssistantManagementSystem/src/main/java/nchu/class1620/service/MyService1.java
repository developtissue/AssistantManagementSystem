package nchu.class1620.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nchu.class1620.entity.AttendExperiment;
import nchu.class1620.entity.Course;
import nchu.class1620.entity.Experiment;
import nchu.class1620.dto.MyEntity1;
import nchu.class1620.entity.Student;
import nchu.class1620.repository.AttendExperimentRepository;
import nchu.class1620.repository.CourseRepository;
import nchu.class1620.repository.ExperimentRepository;
import nchu.class1620.repository.StudentRepository;

/*
 * author: 16202125-吴俊雄
 * @Service层  
 *  MyService1类主要进行实验成绩方面的业务逻辑操作
 */

@Service
public class MyService1 {

	@Autowired
	private ExperimentRepository experimentRepo;
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private AttendExperimentRepository attendExperimentRepo;
	
	public List<MyEntity1> getMyEntity1List(Integer sid){
		List<MyEntity1> result = new ArrayList<>();
		
		List<AttendExperiment> list = attendExperimentRepo.findByStuId(sid);
		for (AttendExperiment ae : list) {
			MyEntity1 e = new MyEntity1();
			e.setS_id(sid);
			Student student = studentRepo.findById(sid);
			e.setS_name(student.getS_name());
			Course course = courseRepo.findById(ae.getE_id());
			e.setC_name(course.getC_name());
			Experiment experiment = experimentRepo.findById(ae.getE_id());
			e.setE_name(experiment.getE_name());
			e.setE_content(experiment.getE_content());
			e.setAe_grade(ae.getAe_grade());
			result.add(e);
		}
		return result;
	}
	
	public List<MyEntity1> getMyEntity1List2(Integer clsid){
		List<MyEntity1> result = new ArrayList<>();
		
		List<Student> stuList = studentRepo.findByClsId(clsid);
		for(Student s : stuList) {
		List<AttendExperiment> list = attendExperimentRepo.findByStuId(s.getS_id());
		for (AttendExperiment ae : list) {
			MyEntity1 e = new MyEntity1();
			e.setS_id(s.getS_id());
			Student student = studentRepo.findById(s.getS_id());
			e.setS_name(student.getS_name());
			Course course = courseRepo.findById(ae.getE_id());
			e.setC_name(course.getC_name());
			Experiment experiment = experimentRepo.findById(ae.getE_id());
			e.setE_name(experiment.getE_name());
			e.setE_content(experiment.getE_content());
			e.setAe_grade(ae.getAe_grade());
			result.add(e);
		}
		}
		return result;
	}
	
	public List<MyEntity1> getMyEntity1List3(Integer sid){
		List<MyEntity1> result = new ArrayList<>();
		
		List<AttendExperiment> list = attendExperimentRepo.findByStuId(sid);
		for (AttendExperiment ae : list) {
			MyEntity1 e = new MyEntity1();
			e.setS_id(sid);
			Student student = studentRepo.findById(sid);
			e.setS_name(student.getS_name());
			Course course = courseRepo.findById(ae.getE_id());
			e.setC_name(course.getC_name());
			Experiment experiment = experimentRepo.findById(ae.getE_id());
			e.setE_name(experiment.getE_name());
			e.setE_content(experiment.getE_content());
			e.setAe_grade(ae.getAe_grade());
			result.add(e);
		}
		return result;
	}
	
}

//private List<Experiment> eList = new ArrayList<Experiment>();
//private List<Course> cList = new ArrayList<Course>();
//private List<AttendExperiment> aeList = new ArrayList<AttendExperiment>();
