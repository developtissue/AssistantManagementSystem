package nchu.class1620.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
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
	@Select("select s.s_id,s.s_name,s.cls_id\r\n" + 
			"from assistadmin.student s,assistadmin.markexperimentreport me \r\n" + 
			"where s.s_id=me.s_id and me.e_id=#{e_id}")
	@Results({ @Result(column = "s.s_id", property = "s_id"), @Result(column = "s.s_name", property = "s_name"),
			@Result(column = "s.s_cls", property = "s_cls")})
	public ArrayList<Student> findExperimetByAssitantId(int e_id);

}
