package com.myboard.shop.controller;

import org.springframework.stereotype.Controller;

import com.myboard.shop.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
}
