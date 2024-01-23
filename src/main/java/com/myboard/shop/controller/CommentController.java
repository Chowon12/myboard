package com.myboard.shop.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.Comment;
import com.myboard.shop.service.CommentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;
	
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
