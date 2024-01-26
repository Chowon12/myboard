package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

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

	@GetMapping(value="/comments")
	public String getCommentList(Model model) {
		List<Comment> commentList;
		try {
			commentList = commentService.getCommentList();
			model.addAttribute("commentList", commentList);
			System.out.println(commentList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "boardDetail";
	}
	
	
	@GetMapping(value="/comment/{id}")
	public String getCommentById(@PathVariable int id, Model model) {
		Comment comment = null;
		try {
			comment = commentService.getCommentById(id);
			System.out.println(comment);
			model.addAttribute("comment", comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "boardDetail";
	}

	@PostMapping(value = "/comment")
	public String insertComment(Comment comment) {
		String view = "error";
		try {
			boolean result = commentService.insertComment(comment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return view;
	}
	
	@DeleteMapping(value = "/comment")
	public String deleteComment(@RequestBody Comment comment, HttpSession session) {
		String view = "error";
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		try {
			boolean result = commentService.deleteComment(comment.getId(), user.getAuthor(), user.getId());
			if(result) {
				view = "redirect:/board" + comment.getBoardId();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return view;
	}
	
}
