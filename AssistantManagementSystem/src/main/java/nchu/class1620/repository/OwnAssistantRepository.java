package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import nchu.class1620.dto.MyEntity4;
import nchu.class1620.entity.OwnAssistant;


/* Created by:Hxj
 * 
 * */
@Mapper
public interface OwnAssistantRepository {
  
/*
 * yuchao 16202128	
 */
	
	
	@Select("insert into ownassistant(t_id,assist_id,c_id) value(#{tid},#{assistid},#{cid});")
	
	public void InsertOwnAssistant(@Param("tid") int tid , @Param("assistid") int assistid , @Param("cid") int cid);
	

	@Update("update ownassistant "
			+ "set t_id=#{t_id},assist_id=#{Assistid},c_id=#{c_id},assist_grade=#{AssistGrade},comment=#{message}"
			+ "where t_id=#{t_id}")
	public void UpdateGradeAndMessage(@Param("t_id") int t_id, @Param("Assistid") int Assistid,@Param("c_id") int c_id, @Param("AssistGrade")double AssistGrade, @Param("message")String message);

	@Select("SELECT assistant.assist_id,assistant.assist_name,ownassistant.assist_grade,ownassistant.comment \r\n"
			+ "from assistant,ownassistant\r\n" + "where assistant.assist_id=ownassistant.assist_id and t_id = #{t_id}; ")
	public List<MyEntity4> findByTid(@Param("t_id") int t_id);

	@Select("select * from ownassistant where assist_id=#{assist_id} ")
	public OwnAssistant findById(@Param("assist_id") int assist_id);

	
	
}
