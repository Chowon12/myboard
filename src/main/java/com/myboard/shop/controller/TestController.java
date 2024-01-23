package com.myboard.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
	
	@GetMapping(value = "/asd")
	public String asd() {
		return "test";
	}
}
