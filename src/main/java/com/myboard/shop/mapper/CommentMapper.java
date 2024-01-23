package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.Comment;

@Mapper
public interface CommentMapper {

	List<Comment> getCommentList() throws SQLException;

	Comment getCommentById(String id) throws SQLException;

	int insertComment(Comment comment) throws SQLException;

}
