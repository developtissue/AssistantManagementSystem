package nchu.class1620.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nchu.class1620.dto.MyEntity3;
import nchu.class1620.repository.ExperimentAvgGradesRepository;
import nchu.class1620.repository.TaskAvgGradesRepository;

/*
 * author: 16202125-�⿡��
 * @Service��  
 *  MyService4����Ҫ�����԰༶Ϊ��λ������ѧ����������ҵ��ƽ���ɼ������ҵ���߼�����
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
