package com.myboard.shop.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.Comment;

@Controller
public class TestController {
	
	@GetMapping(value = "/asd")
	public String asd() {
		return "test";
	}
	@GetMapping(value = "/asd3")
	public String asd31431(Model model) {
		Date date = new Date(new java.util.Date().getTime());
		Board board = new Board().builder()
				.title("asddsafsda")
				.context("sadgcvxzv")
				.regDate(date)
				.writer("fpwwe")
				.build();
		model.addAttribute("board", board);
		return "boardReg";
	}
	
	@PutMapping(value = "/asd7")
	public String asd3143231(Model model) {
		Date date = new Date(new java.util.Date().getTime());
		Board board = new Board().builder()
				.title("asddsafsda")
				.context("sadgcvxzv")
				.regDate(date)
				.writer("fpwwe")
				.build();
		model.addAttribute("board", board);
		return "boardReg";
	}
	
	@GetMapping(value = "/asd2")
	public String asd2(Model model) {
		Date date = new Date(new java.util.Date().getTime());
		Board board = new Board().builder()
									.title("asddsafsda")
									.context("sadgcvxzv")
									.regDate(date)
									.writer("fpwwe")
									.build();
		Comment comment = new Comment().builder()
										.writer("sdafdsfa")
										.context("xzcvzxv")
										.date(date)
										.build();
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(comment);
		model.addAttribute("board", board);
		model.addAttribute("comments", comments);
		return "boardDetail";
	}
	
	@PostMapping(value = "/asd3")
	public String asd3(String title, String content) {
		System.out.println(title);
		System.out.println(content);
		return "boardReg";
	}
	@DeleteMapping(value = "/asd")
	public ResponseEntity<String> asd4() {
		System.out.println("댓글딜리트");
		return ResponseEntity.ok("댓글이 삭제되었습니다.");
	}
	@DeleteMapping(value = "/asdf")
	public void asd5() {
		System.out.println("글딜리트");
	}
}
