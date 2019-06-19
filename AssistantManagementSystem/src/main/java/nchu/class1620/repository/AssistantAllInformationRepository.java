package nchu.class1620.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import nchu.class1620.dto.AssistantAllInformation;

/*
 * 	16202128 ”‡≥¨
 */

@Mapper
public interface AssistantAllInformationRepository {
	
	@Select("select DISTINCT a.assist_id , c.c_name , a.assist_name , oa.t_id , t.t_name \r\n" + 
			"from assistant a , ownassistant oa, studentandassistant saa , student s,\r\n" + 
			"     writeapplicationform waf ,teacher t , course c \r\n" + 
			"where a.assist_id = oa.assist_id and oa.c_id = c.c_id and\r\n" + 
			"		  oa.t_id = t.t_id and waf.s_id = s.s_id ")
	public List<AssistantAllInformation> findAllAssistantInformation();
	
}
