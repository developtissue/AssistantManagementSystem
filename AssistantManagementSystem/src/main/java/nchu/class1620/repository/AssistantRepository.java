package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import nchu.class1620.entity.OwnAssistant;

@Mapper
public interface AssistantRepository {
	
	
	@Select("SELECT assistant.assist_id,assistant.assist_name,ownassistant.assist_grade,ownassistant.comment \r\n" 
			+ "from assistant,ownassistant\r\n" 
			+ "where assistant.assist_id=ownassistant.assist_id; ")
	public List<OwnAssistant> findAll();
}
