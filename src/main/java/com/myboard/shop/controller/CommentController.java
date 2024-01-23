package com.myboard.shop.controller;

import org.springframework.stereotype.Controller;

import com.myboard.shop.service.CommentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;
}
