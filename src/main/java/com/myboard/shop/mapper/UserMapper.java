package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myboard.shop.dto.User;

@Mapper
public interface UserMapper {

	List<User> getAllUserList() throws SQLException;

	User getUserByUserId(String id) throws SQLException;

	int insertUser(User user) throws SQLException;
	
	int updateUserPW(String id) throws SQLException;

	int deleteUser(@Param("user") User user, 
					@Param("sessionAuthor") Integer sessionAuthor) throws SQLException;

	User getUserByIdAndPw(@Param("id") String id, @Param("password") String password) throws SQLException;

}
