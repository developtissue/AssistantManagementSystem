package nchu.class1620;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import nchu.class1620.AssitantManagementSystemApplication;
import nchu.class1620.entity.AttendExperiment;
import nchu.class1620.entity.Teacher;
import nchu.class1620.dto.MyEntity1;
import nchu.class1620.repository.AttendExperimentRepository;
import nchu.class1620.repository.TeacherRepository;
import nchu.class1620.service.AdminService;
import nchu.class1620.service.AssistantService;
import nchu.class1620.service.MyService1;
import nchu.class1620.service.StudentService;
import nchu.class1620.service.TeacherService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AssitantManagementSystemApplication.class)
public class AssitantManagementSystemApplicationTests {

	@Autowired
	TeacherService ts;
	
	@Autowired
	AdminService as;
	
	@Autowired
	StudentService ss;
	
	@Autowired
	AssistantService ass;
	
	@Test
	public void test() {
		Teacher t = new Teacher(); 
		t.setId(1);
		t.setName("张恒峰");
		t.setPassword("123");
		System.out.println(ts.InsertPublishRecruitment(t, "web", "需要努力的人"));
	}
}
