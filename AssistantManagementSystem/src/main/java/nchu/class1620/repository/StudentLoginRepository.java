package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import nchu.class1620.entity.Assistant;
import nchu.class1620.entity.Student;

/*
 * 16202128 
 * ”‡≥¨
 */

@Mapper
public interface StudentLoginRepository {

	@Results(id="studentMap", value={ 
	@Result(property = "s_id", column = "s_id" , jdbcType=JdbcType.INTEGER), 
	@Result(property = "s_name", column = "s_name" ),
	@Result(property = "cls_id", column = "cls_id" , jdbcType=JdbcType.INTEGER),
	@Result(property = "password", column = "s_password" )
	})
			
	@Select("SELECT * from student where s_id=#{id} and s_password=#{password}")
	public Student findStudentById(@Param("id") String id , @Param("password") String password);
	
	
	
}
