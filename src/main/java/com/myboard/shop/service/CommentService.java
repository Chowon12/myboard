package com.myboard.shop.service;

import org.springframework.stereotype.Service;

import com.myboard.shop.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentMapper commentMapper;
}
