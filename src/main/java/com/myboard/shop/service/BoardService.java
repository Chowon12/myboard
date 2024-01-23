package com.myboard.shop.service;

import java.sql.Date;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.Board;
import com.myboard.shop.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardMapper boardMapper;

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
