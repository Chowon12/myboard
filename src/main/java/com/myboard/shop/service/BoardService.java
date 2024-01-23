package com.myboard.shop.service;

import org.springframework.stereotype.Service;

import com.myboard.shop.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardMapper boardMapper;
}
