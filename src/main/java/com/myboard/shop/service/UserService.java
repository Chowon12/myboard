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
		user = new User().builder()
							.id("asd")
							.password("zxc")
							.author(1)
							.build();
		
		System.out.println(user);
		
		int result = userMapper.insertUser(user);	
		
		return result == 0 ? false : true;
		
	}
	
	public User getUserByUserId(String id) throws SQLException {
		return userMapper.getUserByUserId(id); 
	}

	public boolean updateUserPW(String id) throws SQLException {
		boolean result = false;

		int res = userMapper.updateUserPW(id);

		if (res != 0) {
			result = true;
		} else {
			new Exception("회원정보 수정 실패");
		}

		return result;

	}

	public boolean deleteUser(User user) throws SQLException {
		int result = userMapper.deleteUser(user);	
		return result == 0 ? false : true;
		
	}

}
