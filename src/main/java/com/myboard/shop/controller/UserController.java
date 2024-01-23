package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myboard.shop.dto.User;
import com.myboard.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping(value="/users")
	public String getUserList(Model model) {
		List<User> userList;
		try {
			userList = userService.getAllUserList();
			model.addAttribute("userList", userList);
			model.addAttribute("userList", userList);
			System.out.println(userList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "user";
	}
	
	
	@GetMapping(value="/user/{id}")
	public String getUserById(@PathVariable String id, Model model) {
		User user = null;
		try {
			user = userService.getUserById(id);
			System.out.println(user);
			model.addAttribute("user", user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "userDetail";
	}
	
	

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
