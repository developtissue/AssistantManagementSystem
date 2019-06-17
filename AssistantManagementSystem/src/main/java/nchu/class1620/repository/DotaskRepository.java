package nchu.class1620.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import nchu.class1620.entity.DoTask;

/*hxj
*/
@Mapper
public interface DotaskRepository {
	@Select("SELECT * from dotask where s_id=#{sid} limit 1")
	public DoTask findById(Integer sid);
}
