package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.Task;

/*
 * author: 16202125-�⿡��
 * TaskRepository �������ݿ����
 */

@Mapper
public interface TaskRepository {

	@Select("SELECT * from task where t_id=#{tid} limit 1") 
	public Task findById(@Param("tid")Integer tid);
	
}
