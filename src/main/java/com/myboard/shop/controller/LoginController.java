package com.myboard.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myboard.shop.dto.User;
import com.myboard.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final UserService userService;
	
	@GetMapping(value = "/login")
	public String loginPage() {
		
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(String id, String pw, HttpSession session, Model model) {
		try {
			User user = userService.getUserByUserId(id);			
			if (user != null && pw.equals(user.getPassword())) {
				session.setAttribute("user", user);
				return "redirect:/main";
			}
		} catch (Exception e) {
			model.addAttribute("message","로그인 실패 : 예외가 발생함");
			return "error";
		}
		model.addAttribute("message","로그인 실패 : 일치하는 정보가 존재하지 않음");
		return "error";
	}
	
	@GetMapping(value = "/logout") // 세션스테이터스로하면 다날아가서 http세션받아서 조금만 날릴꺼면 세션인벨리데이트하는게 좋음
	public String logout(HttpSession session) {
		if (session.getAttribute("userId") != null) {
			session.invalidate();
		}		
		return "login";
	}
}
