package nchu.class1620.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.dto.MyEntity1;

@Mapper
public interface QueryRepository {
/*
 * List result = new arr;
 * id ¡ª¡ª-¡· List<xe>
 * for(e in ex) {
 * 	en = new E
 * 	en.set(),id
 * 	e.id --> courseId
 * 	e.id --> e.name, e.content
 * 	en,set
 * }
 */
	//SELECT student.s_id,student.s_name,course.c_name,e_name,e_content,ae_grade FROM student,experiment,course,openexperiment,attendexperiment WHERE student.s_id = attendexperiment.s_id AND experiment.e_id = attendexperiment.e_id AND openexperiment.e_id = experiment.e_id AND openexperiment.c_id = course.c_id AND student.s_id = 16202101;
	@Select("SELECT student.s_id,student.s_name,course.c_name,e_name,e_content,ae_grade FROM student,experiment,course,openexperiment,attendexperiment WHERE student.s_id = attendexperiment.s_id AND experiment.e_id = attendexperiment.e_id AND openexperiment.e_id = experiment.e_id AND openexperiment.c_id = course.c_id AND student.s_id = 16202101;") 
	public List<MyEntity1> findAll();
	
}