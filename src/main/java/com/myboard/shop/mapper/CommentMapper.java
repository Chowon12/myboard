package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myboard.shop.dto.Comment;

@Mapper
public interface CommentMapper {

	List<Comment> getCommentList() throws SQLException;

	Comment getCommentById(int id) throws SQLException;

	int insertComment(Comment comment) throws SQLException;

	int deleteComment(@Param("id") int id, 
						@Param("author") Integer author, 
						@Param("userid") String userid) throws SQLException;
	
}
