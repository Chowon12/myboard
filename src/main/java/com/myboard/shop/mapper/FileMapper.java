package com.myboard.shop.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myboard.shop.dto.File;

@Mapper
public interface FileMapper {

	File getFileByfileNo(int fileNo) throws Exception;

}
