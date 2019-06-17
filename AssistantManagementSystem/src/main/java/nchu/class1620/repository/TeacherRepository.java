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
	public Teacher findTeacherById(@Param("id") int id, @Param("password") int password);

	  @Select("select teacher.t_id,teacher.t_name from teacher limit 1")
	  public Teacher findTeacher();
	 
}
