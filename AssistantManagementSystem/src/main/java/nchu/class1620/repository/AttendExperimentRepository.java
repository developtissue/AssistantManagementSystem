package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.AttendExperiment;
import nchu.class1620.entity.Experiment;

@Mapper
public interface AttendExperimentRepository {

	@Select("SELECT student.s_id,experiment.e_id,ae_grade,ae_time "
			+ "FROM student,experiment,attendexperiment "
			+ "where student.s_id = 16202101 "
			+ "and student.s_id = attendexperiment.s_id "
			+ "and experiment.e_id = attendexperiment.e_id;") 
	public List<AttendExperiment> findAll();
	
	@Select("SELECT * from attendexperiment where s_id=#{sid}")
	public List<AttendExperiment> findByStuId(Integer sid);
	
}
