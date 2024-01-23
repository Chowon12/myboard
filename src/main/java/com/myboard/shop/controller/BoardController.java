package com.myboard.shop.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.User;
import com.myboard.shop.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@PostMapping(value = "/board")
	public String insertBoard(Board board) {
		String view = "error";
		try {
			boolean result = boardService.insertBoard(board);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return view;
	}
}
