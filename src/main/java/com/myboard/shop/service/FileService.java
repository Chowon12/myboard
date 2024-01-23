package com.myboard.shop.service;

import org.springframework.stereotype.Service;

import com.myboard.shop.mapper.FileMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {

	private final FileMapper fileMapper;
}
