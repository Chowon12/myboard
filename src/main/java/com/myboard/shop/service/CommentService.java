package com.myboard.shop.service;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.mapper.CommentMapper;
import com.myboard.shop.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	
	private final CommentMapper mapper = null;

	public Comment getCommentById(int id) {
		return mapper.getCommentById(id);
	}

}
