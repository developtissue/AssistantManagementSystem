package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.Student;

@Mapper
public interface StudentRepository {

	@Select("SELECT * from student where s_id=#{sid} limit 1") 
	public Student findById(Integer sid);
	
}
