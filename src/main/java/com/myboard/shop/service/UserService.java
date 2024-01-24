package com.myboard.shop.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.User;
import com.myboard.shop.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserMapper mapper;
	
	public User getUserByUserId(String id) {
		return mapper.getUserByUserId(id); 
	}

	public boolean updateUserPW(String id) throws SQLException {
		boolean result = false;

		int res = mapper.updateUserPW(id);

		if (res != 0) {
			result = true;
		} else {
			new Exception("회원정보 수정 실패");
		}

		return result;

	}



}
