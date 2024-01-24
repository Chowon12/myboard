package com.myboard.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.service.CommentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommentController {
	private final CommentService commentService;

	@RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
	public String getCommentById(@PathVariable int id, Model model) {
		Comment comment = null;
		try {
			comment = commentService.getCommentById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("comment", comment);

		return "boardDetail";
	}
}
