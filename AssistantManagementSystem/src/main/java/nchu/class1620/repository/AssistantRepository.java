package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import nchu.class1620.entity.Assistant;

/*
 * 
 * yuchao
 * use for Login in
 * 
 */


@Mapper
public interface AssistantRepository {
	
	@Results(id="assistantMap", value={ 
	@Result(property = "assist_id", column = "assist_id" , jdbcType=JdbcType.INTEGER), 
	@Result(property = "assist_name", column = "assist_name" ),
	@Result(property = "password", column = "assist_password" )
	})
	
	@Select("SELECT * from assistant where assist_id=#{assist_id} and assist_password=#{password}")
	public Assistant findAssistantById(@Param("assist_id") int assist_id , @Param("password") int password);
	
	@Select("SELECT max(assist_id) from assistant ")
	public int findMaxId();
		
	@Select("insert into assistant(assist_id , assist_name , assist_password) values(#{assist_id},#{name},#{password})")
	public Assistant InsertAssistant(@Param("assist_id") int assist_id, @Param("name") int name , @Param("password") int password);
	
	
	
}






