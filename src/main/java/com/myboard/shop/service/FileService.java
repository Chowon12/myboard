package com.myboard.shop.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myboard.shop.dto.BoardFile;
import com.myboard.shop.mapper.FileMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {

	private final FileMapper fileMapper;

	public List<BoardFile> getAllFileList() throws SQLException {
		List<BoardFile> files = fileMapper.getAllFileList();
		return null;
	}

	public BoardFile getFileByFileno(int fileno) throws SQLException {
		BoardFile file = fileMapper.getFileByFileno(fileno);
		return file;
	}

	public boolean insertFile(MultipartFile file) throws SQLException {
		int result = 0;
		Date date = new Date(new java.util.Date().getTime());
		BoardFile realFile = new BoardFile().builder()
									.path("asd")
									.date(date)
									.fileSize(1)
									.fileName("zxc")
									.boardId(2)
									.build();
//		System.out.println(realFile);
		result = fileMapper.insertFile(realFile);
		return result == 0 ? false : true;
	}
	
	
}
