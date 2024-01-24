package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.Board;

@Mapper
public interface BoardMapper {

	List<Board> getAllBoardList() throws SQLException;

	Board getBoardByTitle(String title) throws SQLException;

	int insertBoard(Board board) throws SQLException;

	Board getBoardByfileNo(int fileNo);

	int updateBoard(Board board) throws SQLException;

}
