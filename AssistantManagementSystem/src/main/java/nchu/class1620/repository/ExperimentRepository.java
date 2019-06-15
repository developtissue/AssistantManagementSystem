package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.Experiment;

@Mapper
public interface ExperimentRepository {

	@Select("SELECT * from experiment where e_id=#{eid} limit 1")
	public Experiment findById(Integer eid);

	/*
	 * Created by ZhangJing Notes:If you modify this class,you should keep
	 * attributes and methods which i have already done.But you can add what you
	 * want.
	 */
	@Select("select e.e_id,e.e_name,e.e_content from assistadmin.experiment e,assistadmin.markexperimentreport me where me.e_id=e.e_id and me.assist_id=#{assit_id}")
	@Results({ @Result(column = "e.e_id", property = "e_id"), @Result(column = "e.e_name", property = "e_name"),
			@Result(column = "e.e_content", property = "e_content") })
	public List<Experiment> findByAssitantId(int assit_id);
	
	@Select("SELECT e_name from experiment where e_id=#{eid}")
	public String findByExperimentName(int e_id);
}
