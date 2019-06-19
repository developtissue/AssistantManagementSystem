package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Value;

import nchu.class1620.dto.StudentApplyInformation;
import nchu.class1620.entity.Assistant;

/*
 * 16202128 yuchao
 * by 管理员查询学生申请状态
 */

@Mapper
public interface StudentApplyInformationRepository {

	@Results(id="studentapplyinformationMap", value={ 
	@Result(property = "s_id", column = "s_id" , jdbcType=JdbcType.INTEGER), 
	@Result(property = "s_name", column = "s_name" ),
	@Result(property = "date", column = "employ_time" ),
	@Result(property = "t_id", column = "t_id" , jdbcType=JdbcType.INTEGER),
	@Result(property = "t_name", column = "t_name" ),
	@Result(property = "c_id", column = "c_id" , jdbcType=JdbcType.INTEGER),
	@Result(property = "c_name", column = "c_name" ),
	@Result(property = "status", column = "status" ),
	@Result(property = "comment", column = "comment" )
	})
	
	@Select("select s.s_id , af.employ_time , t.t_id ,t.t_name , c.c_id , s.s_name , waf.status , c_name ,comment \r\n" + 
			"from applicationform af, writeapplicationform waf, publishapplication pa , student s , teacher t , course c\r\n" + 
			"where af.application_id = waf.application_id and \r\n" + 
			"	   waf.application_id = pa.application_id and \r\n" + 
			"      s.s_id = waf.s_id and t.t_id = pa.t_id and\r\n" + 
			"	   c.c_id = pa.c_id")
	public List<StudentApplyInformation> findAllStudentApplyIn();
	
	
	@Select("select s.s_id , af.employ_time , t.t_id ,t.t_name , c.c_id , s.s_name , waf.status , c_name ,comment \r\n" + 
			"from applicationform af, writeapplicationform waf, publishapplication pa , student s , teacher t , course c\r\n" + 
			"where af.application_id = waf.application_id and \r\n" + 
			"	   waf.application_id = pa.application_id and \r\n" + 
			"      s.s_id = waf.s_id and t.t_id = pa.t_id and\r\n" + 
			"	   c.c_id = pa.c_id  and s.s_id=#{id}")
	@Value("studentapplyinformationMap")
	public StudentApplyInformation findStudentApplyInforByStuid(@Param("id") int id);
	
	
	@Select("update writeapplicationform\r\n" + 
			"set comment = #{comment}\r\n" + 
			"where s_id = #{id};")
	public void FailedUpdateComment(@Param("id") int id,@Param("comment") String comment);
	
	@Select("update writeapplicationform\r\n" + 
			"set comment = #{comment} , status = '录取' \r\n" + 
			"where s_id = #{id};")
	public void SuccessUpdateComment(@Param("id") int id,@Param("comment") String comment);
}
