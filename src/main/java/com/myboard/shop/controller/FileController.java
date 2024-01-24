package com.myboard.shop.controller;

import org.springframework.stereotype.Controller;

import com.myboard.shop.service.FileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FileController {
	public final FileService fileService;
	
	
	
}
