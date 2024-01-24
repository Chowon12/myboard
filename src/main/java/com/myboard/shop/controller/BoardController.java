package com.myboard.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.File;
import com.myboard.shop.service.BoardService;
import com.myboard.shop.service.FileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	private final FileService fileService;
	
	@RequestMapping(value = "/board/{fileNo}", method = RequestMethod.GET)
	public String getBoardByfileNo(@PathVariable int fileNo, Model model) {
		Board board = null;
		File file = null;
		try {
			board = boardService.getBoardByfileNo(fileNo);
			file = fileService.getFileByfileNo(fileNo);
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
		File file = fileService.getFileByfileNo(fileNo);
		
		model.addAttribute("board", board);
		model.addAttribute("file", file);
		
		return "updateBoard";
	}
	
	@RequestMapping(value = "/board/{fileNo}", method = RequestMethod.POST)
	public String updateBoardTitleAndContext(@PathVariable int fileNo,
										@ModelAttribute Board newBoard) {
		
		System.out.println("POST");
		String view = "error";
		
		System.out.println(fileNo);
		System.out.println(newBoard.getFileNo());
		System.out.println(newBoard.getTitle());
		System.out.println(newBoard.getContext());
		
		
		Board board = null;
		boolean result = false;
		try {
			board = boardService.getBoardByfileNo(fileNo);
			
			board.setTitle(newBoard.getTitle());
			board.setContext(newBoard.getContext());
			
			result = boardService.updateBoardTitleAndContext(board);
			
			if(result) {
				view = "redirect:/board/" + fileNo;
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
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
			
			result = boardService.updateBoardTitleAndContext(newBoard);
			
			if(file != null) {
				fileService.insertFile(file, board.getFileNo());
			}
			
			if(result) {
				view = "redirect:/board/" + fileNo;
				return view;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}
	
	
}
