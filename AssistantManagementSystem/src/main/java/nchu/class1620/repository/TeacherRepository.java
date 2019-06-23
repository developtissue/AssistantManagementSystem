package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import nchu.class1620.entity.Teacher;

/*
 * 16202128 ”‡≥¨
 * 
 */
@Mapper
public interface TeacherRepository {

	@Results(id = "teacherMap", value = { @Result(property = "id", column = "t_id", jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "t_name"), @Result(property = "password", column = "t_password") })

	@Select("SELECT * from teacher where t_id=#{id} and t_password=#{password}")
	public Teacher findTeacherById(@Param("id") String id, @Param("password") String password);

	@Select("select teacher.t_id,teacher.t_name from teacher limit 1")
	public Teacher findTeacher();
	
	@Select("insert into publishapplication(t_id,application_id,c_id,request) value(#{t_id}, #{application_id},#{c_id}, #{request})")
	public void InsertPublishRecruitment(@Param("t_id")int t_id , @Param("application_id")int application_id , @Param("c_id")int c_id ,@Param("request")String request);
	  

	@Select("SELECT max(application_id) from applicationform")
	public int findMaxAppId();

	@Select("insert into applicationform(application_id,employ_txt) value(#{id},#{request})")
	public void InsertApplicationForm(@Param("id")int id , @Param("request")String request);
	
	@Select("select c_id from course where c_name = #{name}")
	public Integer FindCourseId(@Param("name")String name);
	
	
}
