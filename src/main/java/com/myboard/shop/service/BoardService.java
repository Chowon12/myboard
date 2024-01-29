package com.myboard.shop.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.Comment;
import com.myboard.shop.mapper.BoardMapper;
import com.myboard.shop.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardMapper boardMapper;
	private final CommentMapper commentMapper;
	
	public Board getBoardByfileNo(int fileNo) {
		return boardMapper.getBoardByfileNo(fileNo); 
	}

	public boolean updateBoard(Board board) throws SQLException {
		return boardMapper.updateBoard(board);
	}

	public List<Board> getAllBoardList() throws SQLException {
		List<Board> boards = boardMapper.getAllBoardList();
		return boards;
	}

	public List<Board> getBoardByTitle(String title) throws SQLException {
		List<Board> board = boardMapper.getBoardByTitle(title);
		return board;
	}

	public boolean insertBoard(Board newBoard) throws SQLException {
		int result = boardMapper.insertBoard(newBoard);
		
		return result == 0 ? false : true;
	}

//	public boolean deleteBoard(int fileno, Integer author, String id) throws SQLException {
//		int result = boardMapper.deleteBoard(fileno, author, id);	
//		return result == 0 ? false : true;
//	}
	
	public int getAuthor(int fileNo) throws SQLException {
	    return boardMapper.getAuthor(fileNo);
	}
	
	public boolean isAuthor(int fileNo, String id) throws SQLException{
		int author = boardMapper.getAuthor(fileNo);
	    // 사용자의 id가 문자열이므로, 문자열로 변환하여 비교합니다.
	    return author == 0 || String.valueOf(author).equals(id);
	}

	public boolean deleteBoard(int fileNo) throws SQLException{
		return boardMapper.deleteBoard(fileNo);
	}
	
	public void deleteBoardAndComments(int fileNo) throws SQLException {
	    commentMapper.deleteCommentByBoardId(fileNo);
	    boardMapper.deleteBoard(fileNo);
	}
	
}
