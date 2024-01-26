package com.myboard.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboard.shop.dto.User;
import com.myboard.shop.service.UserService;

@Controller
public class LoginController {
	private final UserService userService = null;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String password,
						HttpSession session) {
		String view = "error";
		User user = null;
		try {
			user = userService.getUserByIdAndPw(id, password);
			System.out.println(user);
			
			// 세션 : setAttribute("key", value); 생성 -> main이동
			if(user != null) {
				session.setAttribute("userId", user.getId());
				session.setAttribute("userPw", user.getPassword());
			
				view = "redirect:/main";
				return view;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return view;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/main";
	}
}
