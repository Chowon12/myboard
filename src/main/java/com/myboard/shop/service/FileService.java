package com.myboard.shop.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myboard.shop.dto.File;
import com.myboard.shop.mapper.FileMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {

	private final FileMapper fileMapper;

	public List<File> getAllFileList() throws SQLException {
		List<File> files = fileMapper.getAllFileList();
		return null;
	}

	public File getFileByFileno(int fileno) throws SQLException {
		File file = fileMapper.getFileByFileno(fileno);
		return file;
	}
}
