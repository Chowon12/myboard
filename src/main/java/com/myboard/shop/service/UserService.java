package com.myboard.shop.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.User;
import com.myboard.shop.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {	
	
	private final UserMapper userMapper;

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
