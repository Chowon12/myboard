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

	@PostMapping(value = "/board/u")
	public String updateBoard(@ModelAttribute Board newBoard, HttpSession session) throws SQLException {
		User user = (User) session.getAttribute("user");
		if (user != null && (user.getAuthor() == 0 || boardService.isAuthor(newBoard.getFileNo(), user.getId()))) {
			try {
				boolean result = boardService.updateBoard(newBoard);
				if (result) {
					return "redirect:/board/" + newBoard.getFileNo();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "error";
	}

	@GetMapping(value = "/boards")
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

	@GetMapping(value = "/board/search/{title}")
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

	// /reg/board
	@RequestMapping(value = "/reg/board", method = RequestMethod.GET)
	public String insertBoardForm(Model model) throws Exception {

		return "boardReg";
	}

	@PostMapping(value = "/board/i")
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

				if (result) {
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

	@RequestMapping(value = "/board/{fileNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBoard(@PathVariable("fileNo") int fileNo, HttpSession session) throws SQLException {
		User user = (User) session.getAttribute("user");
		if (user != null && (user.getAuthor() == 0 || boardService.isAuthor(fileNo, user.getId()))) {
			try {
				// 해당 보드와 해당 보드에 연결된 모든 댓글을 삭제합니다.
				boardService.deleteBoardAndComments(fileNo);
				return ResponseEntity.ok("보드와 댓글 삭제 성공");
			} catch (SQLException e) {
				e.printStackTrace();
				return ResponseEntity.status(500).body("보드와 댓글 삭제 실패");
			}
		} else {
			return ResponseEntity.status(403).body("삭제 권한 없음"); // 권한 없을 경우 403 에러 반환
		}
	}

}
