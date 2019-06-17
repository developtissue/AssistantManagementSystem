package nchu.class1620.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import nchu.class1620.entity.OwnAssistant;

/* Created by:Hxj
 * 
 * */
@Mapper
public interface OwnAssistantRepository {
  
	
	/*
	 * @Insert("insert into ownassistant values (#{t_id},#{Assistid},#{AssistGrade},#{message})"
	 * ) public OwnAssistant InsertAll(int t_id,int Assistid,double
	 * AssistGrade,String message);
	 */
}
