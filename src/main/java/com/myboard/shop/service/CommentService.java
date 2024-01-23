package com.myboard.shop.service;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentMapper commentMapper;

	public boolean insertComment(Comment comment) throws SQLException {
		Date date = new Date(new java.util.Date().getTime());
		comment = new Comment().builder()
								.context("zxc")
								.date(date)
								.writer("asd")
								.userId("asd")
								.boardId(2)
								.build();

		System.out.println(comment);
								
		int result = commentMapper.insertComment(comment);
		
		return result == 0 ? false : true;
	}
}
