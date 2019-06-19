package nchu.class1620.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import nchu.class1620.entity.Admin;
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
	
}
