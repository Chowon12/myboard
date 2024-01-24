package com.myboard.shop.service;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.File;
import com.myboard.shop.mapper.FileMapper;
import com.myboard.shop.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {
	
	private final FileMapper mapper = null;

	public File getFileByfileNo(int fileNo) throws Exception {
		File file = null;

		file = mapper.getFileByfileNo(fileNo);
		return file;
	}

}
