package com.myboard.shop.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.File;

@Mapper
public interface FileMapper {

	List<File> getAllFileList() throws SQLException;

	File getFileByFileno(int fileno) throws SQLException;

}
