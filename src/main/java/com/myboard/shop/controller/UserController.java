package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
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
		System.out.println("포스트매핑");
		try {
			boolean result = userService.insertUser(user);
			view = "login";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return view;
	}
	
	@RequestMapping(value = "/modify/user/{id}", method = RequestMethod.GET)
	public String updateUserForm(String id, Model model) {

		User user;
		try {
			user = userService.getUserByUserId(id);
			model.addAttribute("user", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "userUpdate";
	}
	
	@RequestMapping(value = "/user/u", method = RequestMethod.POST)
	public String updateUserPW(@ModelAttribute User newUser) {
		
		System.out.println("POST");
		String view = "error";
		
		System.out.println(newUser);
		
		
		User user = null;
		boolean result = false;
		try {
			user = userService.getUserByUserId(newUser.getId());
			
//			user.setPassword(newUser.getPassword());
			System.out.println(user);
			result = userService.updateUserPW(user.getId(), newUser.getPassword());
			System.out.println(result);
			if(result) {
				view = "redirect:/user/" + user.getId();
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}
	
	@DeleteMapping(value = "/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId, HttpSession session) {
		String view = "error";
		User userSession = (User) session.getAttribute("user");
		System.out.println("delete " + userId);
		try {
			boolean result = userService.deleteUser(userId, userSession.getAuthor(), userSession.getId());
			System.out.println(result);
			if(result) {
				return ResponseEntity.ok("삭제성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(500).body("삭제실패");
	}
	
	@GetMapping(value = "/user-insert")
	public String insertUserForm() {
		return "userReg";
	}
}
