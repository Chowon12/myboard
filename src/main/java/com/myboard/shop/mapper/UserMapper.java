package com.myboard.shop.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.User;

@Mapper
public interface UserMapper {

	int insertUser(User user) throws SQLException;

}
