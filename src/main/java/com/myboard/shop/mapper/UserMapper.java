package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.User;

@Mapper
public interface UserMapper {

	List<User> getAllUserList() throws SQLException;

	User getUserById(String id) throws SQLException;

	int insertUser(User user) throws SQLException;

}
