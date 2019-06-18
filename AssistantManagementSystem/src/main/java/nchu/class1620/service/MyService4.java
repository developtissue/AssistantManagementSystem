package nchu.class1620.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nchu.class1620.dto.MyEntity3;
import nchu.class1620.repository.ExperimentAvgGradesRepository;
import nchu.class1620.repository.TaskAvgGradesRepository;

/*
 * author: 16202125-吴俊雄
 * @Service层  
 *  MyService4类主要进行以班级为单位的所有学生的所有作业的平均成绩方面的业务逻辑操作
 */

@Service
public class MyService4 {

	@Autowired
    private TaskAvgGradesRepository avgGradesRepo;
	
	public List<MyEntity3> getMyEntity3List(int clsid) {
		List<MyEntity3> result = new ArrayList<MyEntity3>();
		result = avgGradesRepo.findById(clsid);
		for(MyEntity3 r : result) {
			System.out.println(r.getS_id());
			System.out.println(r.getS_name());
			System.out.println(r.getAvgGrade());
		}
		return result;
	}

	
}
