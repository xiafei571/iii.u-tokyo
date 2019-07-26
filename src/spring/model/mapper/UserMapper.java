package spring.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import spring.domain.UserInfo;

public interface UserMapper {
	static String COLUMN = "uid, loginId, uname, password, email, phone, valid, gmt_create, gmt_modified";

	@Select("SELECT " + COLUMN + " FROM user WHERE loginId = #{id}")
	@ResultMap("userResultMap")
	UserInfo getUser(@Param("id") String id);

}
