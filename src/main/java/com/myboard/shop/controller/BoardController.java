package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.BoardFile;
import com.myboard.shop.service.BoardService;
import com.myboard.shop.service.BoardFileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	private final BoardFileService fileService;
	
	@RequestMapping(value = "/board/{fileNo}", method = RequestMethod.GET)
	public String getBoardByfileNo(@PathVariable int fileNo, Model model) {
		Board board = null;
		BoardFile file = null;
		try {
			board = boardService.getBoardByfileNo(fileNo);
			file = fileService.getFileByFileno(fileNo);
			System.out.println(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("board", board);
		model.addAttribute("file", file);
		return "boardDetail";
	}
	
	// /modify/board/10
	@RequestMapping(value = "/modify/board/{fileNo}", method = RequestMethod.GET)
	public String updateBoardForm(@PathVariable int fileNo, Model model) throws Exception {
		
		Board board = boardService.getBoardByfileNo(fileNo);
		BoardFile file = fileService.getFileByFileno(fileNo);
		
		model.addAttribute("board", board);
		model.addAttribute("file", file);
		
		return "boardReg";
	}
	
	// /board/10
	@RequestMapping(value = "/board/{fileNo}", method = RequestMethod.PUT)
	public String updateBoard(@PathVariable int fileNo,
							@ModelAttribute Board newBoard,
							MultipartFile file) throws Exception {
		System.out.println("PUT");
		String view = "error";
		
		
		Board board = null;
		boolean result = false;
		try {
			
			board = boardService.getBoardByfileNo(fileNo);
			
			board.setTitle(newBoard.getTitle());
			board.setContext(newBoard.getContext());
			
			result = boardService.updateBoard(newBoard);
			
			if(file != null) {
				fileService.insertFile(file);
			}
			
			if(result) {
				view = "redirect:/boards/" + fileNo;
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}
	
	
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
		return "main";
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
			view = "boardReg";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return view;
	}
}
