package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.BoardFile;
import com.myboard.shop.dto.Comment;
import com.myboard.shop.dto.User;
import com.myboard.shop.service.BoardService;
import com.myboard.shop.service.CommentService;
import com.myboard.shop.service.BoardFileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	private final BoardFileService fileService;
	private final CommentService commentService;
	
	@RequestMapping(value = "/board/{fileNo}", method = RequestMethod.GET)
	public String getBoardByfileNo(@PathVariable int fileNo, Model model) {
		Board board = null;
		BoardFile file = null;
		List<Comment> comments = null;
		try {
			board = boardService.getBoardByfileNo(fileNo);
			comments = commentService.getCommentByBoardId(board.getFileNo());
//			file = fileService.getFileByFileno(fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(board);
		model.addAttribute("board", board);
		model.addAttribute("comments", comments);
//		model.addAttribute("file", file);
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
				view = "redirect:/board/" + fileNo;
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
	
	
	@GetMapping(value="/board/search/{title}")
	public String getBoardByTitle(@PathVariable String title, Model model) {
		List<Board> board = null;
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
	
	@PostMapping(value = "/boardReg")
	public String insertBoard(Board newBoard, HttpSession session) {
		String view = "error";
		boolean result = false;
		Object objUser = session.getAttribute("user");
		if (objUser != null) {
			try {
				User user = (User) objUser;
				newBoard.setUserId(user.getId());
				newBoard.setWriter(user.getId());
				result = boardService.insertBoard(newBoard);
				
				if(result) {
					view = "boardReg";
					return view;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return view;
			}
		} else {
			session.setAttribute("message", "로그인이 되어있지 않습니다");
		}
		
		return view;
	}
	
	@DeleteMapping(value = "/board/{fileNo}")
	public ResponseEntity<String> deleteBoard(@PathVariable("fileNo") int fileNo, HttpSession session) {
		String view = "error";
		System.out.println(fileNo);
		System.out.println("delete메서드");
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		try {
			boolean result = boardService.deleteBoard(fileNo, user.getAuthor(), user.getId());
			System.out.println(result);
			if(result) {
				return ResponseEntity.ok("삭제성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(500).body("삭제실패");
	}
	
}
