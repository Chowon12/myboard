package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myboard.shop.dto.Comment;

@Mapper
public interface CommentMapper {

	List<Comment> getCommentList() throws SQLException;

	int insertComment(Comment comment) throws SQLException;

	boolean deleteComment(@Param("id") int id) throws SQLException;

	int deleteCommentByBoardId(int fileNo);
	
	List<Comment> getCommentByBoardId(int boardId)throws SQLException;

}
