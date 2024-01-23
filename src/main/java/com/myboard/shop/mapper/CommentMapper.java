package com.myboard.shop.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.Comment;

@Mapper
public interface CommentMapper {

	int insertComment(Comment comment) throws SQLException;

}
