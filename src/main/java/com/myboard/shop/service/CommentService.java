package com.myboard.shop.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.Comment;
import com.myboard.shop.dto.User;
import com.myboard.shop.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class CommentService {

	private final CommentMapper commentMapper;
	
	public List<Comment> getCommentByBoardId(int boardId) throws SQLException {
		return commentMapper.getCommentByBoardId(boardId);
	}


	public List<Comment> getCommentList() throws SQLException {
		List<Comment> commentList = commentMapper.getCommentList();
		return commentList;
	}

	public boolean insertComment(Comment comment) throws SQLException {
		int result = commentMapper.insertComment(comment);
		
		return result == 0 ? false : true;
	}


	public boolean deleteComment(int id) throws SQLException {
		return commentMapper.deleteComment(id);
	}

	public boolean deleteCommentByBoardId(int fileNo) {
        try {
            int rowsAffected = commentMapper.deleteCommentByBoardId(fileNo);
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
