package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import nchu.class1620.entity.OwnAssistant;

/* Created by:Hxj
 * 
 * */
@Mapper
public interface OwnAssistantRepository {

	@Insert("insert into ownassistant values (#{t_id},#{Assistid},#{c_name},#{AssistGrade},#{message})")
	public void InsertAll(int t_id, int Assistid, int c_id, double AssistGrade, String message);

	@Select("SELECT assistant.assist_id,assistant.assist_name,ownassistant.assist_grade,ownassistant.comment \r\n"
			+ "from assistant,ownassistant\r\n" + "where assistant.assist_id=ownassistant.assist_id; ")
	public List<OwnAssistant> findAll();

	@Select("select * from ownassistant where assist_id=#{assist_id} ")
	public OwnAssistant findById(@Param("assist_id") int assist_id);
}
