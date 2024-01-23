package com.myboard.shop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myboard.shop.dto.Board;
import com.myboard.shop.dto.File;
import com.myboard.shop.service.FileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FileController {
	
	private final FileService fileService;
	
	@GetMapping(value="/files")
	public String getAllFileList(Model model) {
		List<File> fileList;
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
		File file = null;
		try {
			file = fileService.getFileByFileno(fileno);
			System.out.println(file);
			model.addAttribute("file", file);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "fileDetail";
	}
}
