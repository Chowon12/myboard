package com.myboard.shop.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.Comment;

@Mapper
public interface CommentMapper {

	public Comment getCommentById(int id);

}
