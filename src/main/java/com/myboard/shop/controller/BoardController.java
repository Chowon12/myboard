package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.User;
import com.myboard.shop.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping(value="/boards")
	public String getBoardList(Model model) {
		List<Board> boardList;
		try {
			boardList = boardService.getAllBoardList();
			model.addAttribute("boardList", boardList);
			System.out.println(boardList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "board";
	}
	
	
	@GetMapping(value="/board/{title}")
	public String getBoardByTitle(@PathVariable String title, Model model) {
		Board board = null;
		try {
			board = boardService.getBoardByTitle(title);
			System.out.println(board);
			model.addAttribute("board", board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "boardDetail";
	}
	
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
