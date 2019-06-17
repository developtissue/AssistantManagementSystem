package nchu.class1620.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nchu.class1620.dto.MyEntity3;
import nchu.class1620.repository.ExperimentAvgGradesRepository;

/*
 * author: 16202125-�⿡��
 * @Service��  
 *  MyService3����Ҫ�����԰༶Ϊ��λ������ѧ��������ʵ���ƽ���ɼ������ҵ���߼�����
 */

@Service
public class MyService3 {

	@Autowired
    private ExperimentAvgGradesRepository avgGradesRepo;
	
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
