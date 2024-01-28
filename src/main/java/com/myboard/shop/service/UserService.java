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

	public boolean insertUser(User user) throws SQLException {
		int result = userMapper.insertUser(user);	
		
		return result == 0 ? false : true;
		
	}
	
	public User getUserByUserId(String id) throws SQLException {
		return userMapper.getUserByUserId(id); 
	}

	public boolean updateUserPW(String id, String password) throws SQLException {
		boolean result = false;

		int res = userMapper.updateUserPW(id, password);

		if (res != 0) {
			result = true;
		} else {
			new Exception("회원정보 수정 실패");
		}

		return result;

	}

	public boolean deleteUser(String id, Integer sessionAuthor, String sessionId) throws SQLException {
		int result = userMapper.deleteUser(id, sessionAuthor, sessionId);
		return result == 0 ? false : true;
	}

	public User getUserByIdAndPw(String id, String password) throws SQLException {
		User user = null;
		
		user = userMapper.getUserByIdAndPw(id, password);
		
		return user;
	}



}
