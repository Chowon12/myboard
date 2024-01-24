package com.myboard.shop.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.Board;
import com.myboard.shop.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper mapper = null;
	
	public Board getBoardByfileNo(int fileNo) {
		return mapper.getBoardByfileNo(fileNo); 
	}

	public boolean updateBoardTitleAndContext(Board board) throws SQLException {
		boolean result = false;

		int res = mapper.updateBoardTitleAndContext(board);

		if (res != 0) {
			result = true;
		} else {
			new Exception("상품정보 수정 실패");
		}

		return result;
	}
}
