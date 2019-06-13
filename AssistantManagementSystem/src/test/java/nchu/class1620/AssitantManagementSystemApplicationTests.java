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
import nchu.class1620.dto.MyEntity1;
import nchu.class1620.repository.AttendExperimentRepository;
import nchu.class1620.service.MyService1;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = AssitantManagementSystemApplication.class)
public class AssitantManagementSystemApplicationTests {

	@Autowired
	AttendExperimentRepository repo;
	
	@Autowired
	MyService1 service;
	
	@Test
	public void test() {
		List<AttendExperiment> list = repo.findByStuId(16202101);
		System.out.println(list);
	}
	
	@Test
	public void testService() {
		List<MyEntity1> list = service.getMyEntity1List(16202101);
		System.out.println(list);
	}

}
