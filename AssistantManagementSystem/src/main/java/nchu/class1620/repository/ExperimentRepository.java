package nchu.class1620.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import nchu.class1620.entity.Experiment;
import nchu.class1620.entity.Report;

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
	@Results({ @Result(column = "e_id", property = "e_id", javaType = Integer.class),
			@Result(column = "e_name", property = "e_name", javaType = String.class),
			@Result(column = "e_content", property = "e_content", javaType = String.class) })
	public List<Experiment> findByAssitantId(int assit_id);

	@Select("SELECT e_name from assistadmin.experiment where e_id=#{eid}")
	public String findByExperimentName(int e_id);

	@Select("select s.s_id,s.s_name,e.e_content,me.mer_grade,me.comment\r\n" + 
			"from assistadmin.student s,assistadmin.markexperimentreport me,assistadmin.experiment e \r\n" + 
			"where s.s_id=me.s_id and me.e_id=e.e_id and  s.cls_id=#{class_id}")
	@Results({ @Result(column = "s_id", property = "s_id"), @Result(column = "s_name", property = "s_name"),
			@Result(column = "e_content", property = "title"), @Result(column = "mer_grade", property = "score"),
			@Result(column = "comment", property = "comment") })
	public ArrayList<Report> findExperiemntRportByClass(int class_id);

	@Update("update assistadmin.markexperimentreport\r\n" + "set mer_grade=#{mer_grade},comment=#{comment}\r\n"
			+ "where assist_id=#{assist_id} and e_id=#{e_id} and s_id=#{s_id};")
	public void UpdateTask(@Param("assist_id") int assist_id, @Param("e_id") int e_id, @Param("s_id") int s_id,
			@Param("mer_grade") double mer_grade, @Param("comment") String comment);
}
