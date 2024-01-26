package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.BoardFile;

@Mapper
public interface BoardFileMapper {

	List<BoardFile> getAllFileList() throws SQLException;

	BoardFile getFileByFileno(int fileNo) throws SQLException;

	int insertFile(BoardFile file) throws SQLException;

}
