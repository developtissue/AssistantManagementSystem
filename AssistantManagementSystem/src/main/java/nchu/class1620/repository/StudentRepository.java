package nchu.class1620.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import nchu.class1620.entity.Student;

@Mapper
public interface StudentRepository {

	@Select("SELECT * from student where s_id=#{sid} limit 1")
	public Student findById(Integer sid);

	@Select("SELECT * from student where cls_id=#{clsid}")
	public List<Student> findByClsId(Integer clsid);

	/*
	 * Created by ZhangJing Notes:If you modify this class,you should keep
	 * attributes and methods which i have already done.But you can add what you
	 * want.
	 */
	@Select("select s.s_id,s.s_name,s.cls_id,s.s_password\r\n"
			+ "from assistadmin.student s,assistadmin.markexperimentreport me \r\n"
			+ "where s.s_id=me.s_id and me.assist_id=#{assist_id} and me.e_id=#{e_id}")
	@Results({ @Result(column = "s_id", property = "s_id", javaType = Integer.class),
			@Result(column = "s_name", property = "s_name", javaType = String.class),
			@Result(column = "cls_id", property = "cls_id", javaType = Integer.class),
			@Result(column = "s_password", property = "password", javaType = String.class) })
	public ArrayList<Student> findExperimetByAssitantId(@Param("assist_id") int assist_id, @Param("e_id") int e_id);

	@Select("select s.s_id,s.s_name,s.cls_id,s.s_password \r\n" + "from assistadmin.student s,assistadmin.marktask mt\r\n"
			+ "where s.s_id=mt.s_id and mt.task_id=#{t_id} and mt.assist_id=#{assist_id}")
	@Results({ @Result(column = "s_id", property = "s_id", javaType = Integer.class),
			@Result(column = "s_name", property = "s_name", javaType = String.class),
			@Result(column = "cls_id", property = "cls_id", javaType = Integer.class),
			@Result(column = "s_password", property = "password", javaType = String.class) })
	public ArrayList<Student> findTaskByAssitantId(@Param("assist_id") int assist_id, @Param("t_id") int t_id);
	
}
