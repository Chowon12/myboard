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
	
	private final UserMapper usermapper;
	
	public List<User> getAllUserList() throws SQLException {
		
		return usermapper.getAllUserList();
	}

	public User getUserById(String id) throws SQLException {
		User user = usermapper.getUserById(id);
		return null;
	}

}
