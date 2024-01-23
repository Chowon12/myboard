package com.myboard.shop.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myboard.shop.dto.User;
import com.myboard.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping(value = "/user")
	public String insertUser(User user) {
		String view = "error";
		try {
			boolean result = userService.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return view;
	}
}
