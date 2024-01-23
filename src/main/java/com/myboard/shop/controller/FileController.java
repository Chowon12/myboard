package com.myboard.shop.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.shop.dto.File;
import com.myboard.shop.dto.User;
import com.myboard.shop.service.FileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FileController {
	
	private final FileService fileService;
	
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
