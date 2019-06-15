package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import nchu.class1620.entity.Task;

@Mapper
public interface TastRepository {
	/*
	 * Created by ZhangJing Notes:If you modify this class,you should keep
	 * attributes and methods which i have already done.But you can add what you
	 * want.
	 */
	@Select("select t.t_id,t.t_name,t.t_content from task t,marktask mt where mt.task.id=t.t_id and mt.assit_id=#{assit_id}")
	@Results({ @Result(column = "t.t_id", property = "t_id"), @Result(column = "t.t_name", property = "t_name"),
			@Result(column = "t.t_content", property = "t_content") })
	public List<Task> findByAssitantId(int assit_id);
}
