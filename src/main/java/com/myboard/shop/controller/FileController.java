package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.BoardFile;
import com.myboard.shop.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class FileController {
	
	private final FileService fileService;
	
	@GetMapping(value="/files")
	public String getAllFileList(Model model) {
		List<BoardFile> fileList;
		try {
			fileList = fileService.getAllFileList();
			model.addAttribute("fileList", fileList);
			System.out.println(fileList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "file";
	}
	
	
	@GetMapping(value="/file/{fileno}")
	public String getFileByFileno(@PathVariable int fileno, Model model) {
		BoardFile file = null;
		try {
			file = fileService.getFileByFileno(fileno);
			System.out.println(file);
			model.addAttribute("file", file);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "fileDetail";
	}
	

	@PostMapping(value = "/file")
	public String insertFile(MultipartFile file) {
		String view = "error";
		try {
			boolean result = fileService.insertFile(file);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return view;
	}
}

