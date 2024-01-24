package com.myboard.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboard.shop.dto.User;
import com.myboard.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getUserByUserId(String id, Model model) {
		User user = null;
		try {
			user = userService.getUserByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("user", user);
		return "userDetail";
	}
	
	@RequestMapping(value = "/modify/user", method = RequestMethod.GET)
	public String updateUserForm(String id, Model model) {

		User user = userService.getUserByUserId(id);
		
		model.addAttribute("user", user);
		
		return "updateUser";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
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
	
	// /dept/10
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public String updateDept(String id,
							@ModelAttribute User newUser) throws Exception {
		System.out.println("PUT");
		String view = "error";
		
		
		User user = null;
		boolean result = false;
		try {
			
			user = userService.getUserByUserId(id);
			
			user.setPassword(newUser.getPassword());
			
			result = userService.updateUserPW(id);
			
			if(result) {
				view = "redirect:/dept/" + id;
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}
}
