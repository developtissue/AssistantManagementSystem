package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import nchu.class1620.entity.Admin;

/*
 * 16202128 yuchao
 */

@Mapper
public interface AdminRepository {

	@Results(id="adminMap", value={ 
	@Result(property = "id", column = "admin_id" , jdbcType=JdbcType.INTEGER), 
	@Result(property = "name", column = "admin_name" ),
	@Result(property = "password", column = "admin_password" )
	})
					
	@Select("SELECT * from administrator where admin_id=#{id} and admin_password=#{password}")
	public Admin findAdminById(@Param("id") int id , @Param("password") int password);
	
	
	
}
