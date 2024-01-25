package com.myboard.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestsController {
	@GetMapping(value="/asd")
	public String Test() {
		return "main";
	}
}
