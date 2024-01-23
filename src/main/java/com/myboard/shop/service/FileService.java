package com.myboard.shop.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public boolean insertFile(MultipartFile file) throws SQLException {
		int result = 0;
		Date date = new Date(new java.util.Date().getTime());
		File realFile = new File().builder()
									.path("asd")
									.date(date)
									.fileSize(1)
									.fileName("zxc")
									.boardId(2)
									.build();
		System.out.println(realFile);
		result = fileMapper.insertFile(realFile);
		return result == 0 ? false : true;
	}
}
