package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			System.out.println(userList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "userList";
	}
	
	
	@GetMapping(value="/user/{id}")
	public String getUserByUserId(@PathVariable String id, Model model) {
		User user = null;
		try {
			user = userService.getUserByUserId(id);
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
	
	@RequestMapping(value = "/modify/user", method = RequestMethod.GET)
	public String updateUserForm(String id, Model model) {

		User user;
		try {
			user = userService.getUserByUserId(id);
			model.addAttribute("user", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "updateUser";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public String updateUserPW(String id,
										@ModelAttribute User newUser) {
		
		System.out.println("POST");
		String view = "error";
		
		System.out.println(id);
		System.out.println(newUser.getPassword());
		
		
		User user = null;
		boolean result = false;
		try {
			user = userService.getUserByUserId(id);
			
			user.setPassword(newUser.getPassword());
			
			result = userService.updateUserPW(id);
			
			if(result) {
				view = "redirect:/user/" + id;
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}
	
	@DeleteMapping(value = "/user")
	public String deleteUser(@RequestBody User user, HttpSession session) {
		String view = "error";
		User userSession = (User) session.getAttribute("user");
		System.out.println(user);
		try {
			boolean result = userService.deleteUser(user, userSession.getAuthor());
			if(result) {
				view = "redirect:/users";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return view;
	}
}


