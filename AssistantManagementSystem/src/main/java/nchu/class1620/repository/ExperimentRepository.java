package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.Experiment;

/*
 * author: 16202125-�⿡��
 * ExperimentRepository �������ݿ����
 */

@Mapper
public interface ExperimentRepository {

	@Select("SELECT * from experiment where e_id=#{eid} limit 1") 
	public Experiment findById(Integer eid);
		
}
