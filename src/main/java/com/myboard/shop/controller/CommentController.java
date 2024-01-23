package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.dto.User;
import com.myboard.shop.service.CommentService;

import lombok.RequiredArgsConstructor;

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
		return "comment";
	}
	
	
	@GetMapping(value="/comment/{id}")
	public String getCommentById(@PathVariable String id, Model model) {
		Comment comment = null;
		try {
			comment = commentService.getCommentById(id);
			System.out.println(comment);
			model.addAttribute("comment", comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "commentDetail";
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
}
