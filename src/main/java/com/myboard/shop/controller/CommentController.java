package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.dto.User;
import com.myboard.shop.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;

//	@GetMapping(value="/comments/{boardId}")
//	public String getCommentList(Model model, @PathVariable int boardId) {
//		List<Comment> commentList;
//		try {
//			commentList = commentService.getCommentByBoardId(boardId);
//			model.addAttribute("commentList", commentList);
//			System.out.println(commentList);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return "boardDetail";
//	}
	
	
//	@GetMapping(value="/comment/{id}")
//	public String getCommentById(@PathVariable int id, Model model) {
//		Comment comment = null;
//		try {
//			comment = commentService.getCommentById(id);
//			System.out.println(comment);
//			model.addAttribute("comment", comment);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return "boardDetail";
//	}

	@PostMapping(value = "/comment")
	public ResponseEntity<String> insertComment(@RequestBody Comment comment, HttpSession session) {
		String view = "error";
		User userSession = (User) session.getAttribute("user");
		comment.setUserId(userSession.getId());
		try {
			System.out.println(comment);
			
			boolean result = commentService.insertComment(comment);
			if(result) {
				return ResponseEntity.ok("삽입성공"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(500).body("삽입실패");
	}
	
	@DeleteMapping(value = "/comment/{commentId}")
	public ResponseEntity<String> deleteComment(@PathVariable("commentId") int commentId, HttpSession session) {
		String view = "error";
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		System.out.println(commentId);
		try {
			boolean result = commentService.deleteComment(commentId, user.getAuthor(), user.getId());
			if(result) {
				return ResponseEntity.ok("삭제성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(500).body("삭제실패");
	}
	
}
