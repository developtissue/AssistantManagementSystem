package nchu.class1620.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import nchu.class1620.entity.AttendExperiment;
import nchu.class1620.entity.DoTask;

/*
 * author: 16202125-吴俊雄
 * DoTaskRepository 进行数据库访问
 */

@Mapper
public interface DoTaskRepository {


	@Select("SELECT * from dotask where s_id=#{sid}")
	public List<DoTask> findByDoTaskId(Integer sid);
	
	@Select("SELECT * from dotask where s_id=#{sid}")
	public List<DoTask> findByStuId(Integer sid);
	
	@Select("SELECT * from dotask where s_id=#{sid} limit 1")
	public DoTask findById(Integer sid);
	
}
