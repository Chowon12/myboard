package com.myboard.shop.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.User;

@Mapper
public interface UserMapper {

	public User getUserByUserId(String id);

	public int updateUserPW(String id) throws SQLException;



}
