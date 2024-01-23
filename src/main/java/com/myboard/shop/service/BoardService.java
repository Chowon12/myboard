package com.myboard.shop.service;

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

	public List<Board> getAllBoardList() throws SQLException {
		List<Board> boards = boardMapper.getAllBoardList();
		return boards;
	}

	public Board getBoardByTitle(String title) throws SQLException {
		Board board = boardMapper.getBoardByTitle(title);
		return board;
	}
}
