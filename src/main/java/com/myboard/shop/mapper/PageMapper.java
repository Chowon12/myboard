package com.myboard.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.PageRequest;


@Mapper
public interface PageMapper {

	// insertNotice
	public Integer insertBoardToPage(Board board);
	
	// searchKeyword
	public List<Board> getBoardBySearchKeyword(String searchKeyword);

	// getNoticeByPage
	public List<Board> getBoardbyPage(PageRequest pageRequest);

	// getTotalCount(without keyword) -> getTotalCount(with keyword) 
	public int getTotalCount(PageRequest pageRequest);
	
	// searchKeyword + pagination
	public List<Board> getBoardBySearchWithPage(PageRequest pageRequest);
}
