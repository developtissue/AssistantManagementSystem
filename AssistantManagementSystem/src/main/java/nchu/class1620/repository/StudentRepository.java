package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.Student;

/*
 * author: 16202125-吴俊雄
 * StudentRepository 进行数据库访问
 */

@Mapper
public interface StudentRepository {

	@Select("SELECT * from student where s_id=#{sid} limit 1") 
	public Student findById(Integer sid);
	
	@Select("SELECT * from student where cls_id=#{clsid}") 
	public List<Student> findByClsId(Integer clsid);
	
}
