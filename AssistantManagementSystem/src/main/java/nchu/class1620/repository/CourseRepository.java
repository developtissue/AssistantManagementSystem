package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.Course;

@Mapper
public interface CourseRepository {

	@Select("select c.* "
			+ "from openexperiment as oe, course as c "
			+ "where e_id=#{e_id} and oe.c_id=c.c_id limit 1")		
	public Course findById(@Param("e_id")int e_id);
	
}
