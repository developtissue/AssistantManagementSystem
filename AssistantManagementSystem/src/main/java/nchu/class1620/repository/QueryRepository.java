package nchu.class1620.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.dto.MyEntity1;

/*
 * author: 16202125-吴俊雄
 * QueryRepository 进行数据库访问  进行初期测试使用
 */

@Mapper
public interface QueryRepository {
/*
 * List result = new arr;
 * id ——-》 List<xe>
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