package com.myboard.shop.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.PageRequest;
import com.myboard.shop.dto.PageResponse;
import com.myboard.shop.mapper.PageMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PageController {
	
	final PageMapper pageMapper;
	
	@GetMapping("/board-data")
	public void insertBoardToPage() {
		
		IntStream.rangeClosed(1, 200)
					.forEach(i -> {
						Board board = Board.builder()
												.fileNo(i)
												.userId("userId : " + i)
												.writer("userName : " + i)
												.title("title : " + i)
												.context("context : " + i)
												.build();
						
						pageMapper.insertBoardToPage(board);
					});
		
	}
	
	@GetMapping("/search")
	public String moveSearch() {
		return "search";
	}
	
	@GetMapping("/search/keyword")
	public String searchKeyword(String searchKeyword, Model model) {
		List<Board> boardList = pageMapper.getBoardBySearchKeyword(searchKeyword);
		
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		
		return "search";
	}
	
	
	@GetMapping(value = "/main")
	public String searchWithPage(PageRequest pageRequest,
									Model model) {
		System.out.println(pageRequest);
		
		List<Board> boardList = pageMapper.getBoardBySearchWithPage(pageRequest);
		
		int totalCount = pageMapper.getTotalCount(pageRequest);
		
		PageResponse pageResponse = new PageResponse().builder()
									.total(totalCount)
									.pageAmount(pageRequest.getAmount())
									.pageRequest(pageRequest)
									.build();
		
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageInfo", pageResponse);
		
		return "main";
	}
	
	
	
}
