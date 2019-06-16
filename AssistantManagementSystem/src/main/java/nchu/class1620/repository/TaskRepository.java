package nchu.class1620.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import nchu.class1620.entity.Report;
import nchu.class1620.entity.Task;

@Mapper
public interface TaskRepository {
	/*
	 * Created by ZhangJing Notes:If you modify this class,you should keep
	 * attributes and methods which i have already done.But you can add what you
	 * want.
	 */
	@Select("select t.t_id,t.t_name,t.t_content \r\n" + "from assistadmin.task t,assistadmin.marktask mt \r\n"
			+ "where mt.task_id=t.t_id and mt.assist_id=#{assit_id}")
	@Results({ @Result(column = "t_id", property = "t_id"), @Result(column = "t_name", property = "t_name"),
			@Result(column = "t_content", property = "t_content") })
	public ArrayList<Task> findByAssitantId(int assit_id);

	@Select("select s.s_id,s.s_name,t.t_content,mt.task_grade,mt.comment\r\n" + 
			"from assistadmin.student s,assistadmin.marktask mt,assistadmin.task t \r\n" + 
			"where s.s_id=mt.s_id and mt.task_id=t.t_id and s.cls_id=#{class_id}")
	@Results({ @Result(column = "s_id", property = "s_id"), @Result(column = "s_name", property = "s_name"),
			@Result(column = "contnt", property = "title"), @Result(column = "task_grade", property = "score"),
			@Result(column = "comment", property = "comment") })
	public ArrayList<Report> findTaskRportByClass(int class_id);

	@Select("SELECT t_name from assistadmin.task where t_id=#{t_id}")
	public String findByTaskName(int t_id);

	@Update("update assistadmin.marktask\r\n" + "set task_grade=#{task_grade},comment=#{comment}\r\n"
			+ "where assist_id=#{assist_id} and task_id=#{task_id} and s_id=#{s_id};")
	public void UpdateTask(@Param("assist_id") int assist_id, @Param("task_id") int task_id, @Param("s_id") int s_id,
			@Param("task_grade") double task_grade, @Param("comment") String comment);
}
