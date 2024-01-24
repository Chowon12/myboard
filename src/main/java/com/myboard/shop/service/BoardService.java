package com.myboard.shop.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.Board;
import com.myboard.shop.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardMapper boardMapper;
	
	public Board getBoardByfileNo(int fileNo) {
		return boardMapper.getBoardByfileNo(fileNo); 
	}

	public boolean updateBoard(Board board) throws SQLException {
		boolean result = false;

		int res = boardMapper.updateBoard(board);

		if (res != 0) {
			result = true;
		} else {
			new Exception("상품정보 수정 실패");
		}

		return result;
	}

	public List<Board> getAllBoardList() throws SQLException {
		List<Board> boards = boardMapper.getAllBoardList();
		return boards;
	}

	public Board getBoardByTitle(String title) throws SQLException {
		Board board = boardMapper.getBoardByTitle(title);
		return board;
	}

	public boolean insertBoard(Board board) throws SQLException {
		Date date = new Date(new java.util.Date().getTime());
		board = new Board().builder()
							.title("asd/asd/asd")
							.context("asd")
							.regDate(date)
							.writer("asd")
							.userId("asd")
							.build();

		System.out.println(board);
		
		int result = boardMapper.insertBoard(board);
		
		return result == 0 ? false : true;
	}
}
