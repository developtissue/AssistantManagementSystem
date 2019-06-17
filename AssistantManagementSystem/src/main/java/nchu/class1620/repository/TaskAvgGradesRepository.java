package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.dto.MyEntity3;

/*
 * author: 16202125-�⿡��
 * TaskAvgGradesRepository �������ݿ����
 *    ����List<MyEntity3>�������͵Ľӿ�
 */

@Mapper
public interface TaskAvgGradesRepository {
	
	@Select("SELECT student.s_id as s_id,student.s_name as s_name,"
			+ "AVG(dotask.t_grade) as avgGrade "
			+ "FROM student,dotask "
			+ "WHERE student.cls_id=#{cls_id} "
			+ "AND student.s_id=dotask.s_id "
			+ "GROUP BY student.s_id")		
	public List<MyEntity3> findById(int cls_id);

}
