package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.Comment;

@Mapper
public interface BoardMapper {

	List<Board> getAllBoardList() throws SQLException;

	List<Board> getBoardByTitle(String title) throws SQLException;

	int insertBoard(Board newBoard) throws SQLException;

	Board getBoardByfileNo(int fileNo);

//	int updateBoard(Board board) throws SQLException;

//	int deleteBoard(@Param("fileNo") int fileNo, 
//					@Param("author") Integer author, 
//					@Param("userId")String userid) throws SQLException;

	boolean deleteBoard(int fileNo) throws SQLException;
	
    boolean updateBoard(Board board) throws SQLException;
    
    int getAuthor(int fileNo) throws SQLException;
    
    void deleteBoardAndComments(int fileNo) throws SQLException;
}
