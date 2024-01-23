package com.myboard.shop.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.File;

@Mapper
public interface FileMapper {

	int insertFile(File file) throws SQLException;

}
