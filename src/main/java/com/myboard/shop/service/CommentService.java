package com.myboard.shop.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentMapper commentMapper;

	public List<Comment> getCommentList() throws SQLException {
		List<Comment> commentList = commentMapper.getCommentList();
		return commentList;
	}

	public Comment getCommentById(String id) throws SQLException {
		Comment comment = commentMapper.getCommentById(id);
		return null;
	}
}
