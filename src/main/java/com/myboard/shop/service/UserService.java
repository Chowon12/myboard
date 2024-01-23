package com.myboard.shop.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.User;
import com.myboard.shop.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserMapper userMapper;
	
	public List<User> getAllUserList() throws SQLException {
		
		return userMapper.getAllUserList();
	}

	public User getUserById(String id) throws SQLException {
		User user = userMapper.getUserById(id);
		return null;
	}

	public boolean insertUser(User user) throws SQLException {
		user = new User().builder()
							.id("asd")
							.password("zxc")
							.author(1)
							.build();
		
		System.out.println(user);
		
		int result = userMapper.insertUser(user);	
		
		return result == 0 ? false : true;
		
	}
}
