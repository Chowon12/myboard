package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myboard.shop.dto.Board;

@Mapper
public interface BoardMapper {

	List<Board> getAllBoardList() throws SQLException;

	Board getBoardByTitle(String title) throws SQLException;

	int insertBoard(Board newBoard) throws SQLException;

	Board getBoardByfileNo(int fileNo);

	int updateBoard(Board board) throws SQLException;

	int deleteBoard(@Param("fileNo") int fileNo, 
					@Param("author") Integer author, 
					@Param("userid")String userid) throws SQLException;

}
