package com.myboard.shop.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.Board;

@Mapper
public interface BoardMapper {

	int insertBoard(Board board) throws SQLException;

}
