package com.myboard.shop.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class File {
	private int fileNo;
	private String path;
	private Date date;
	private Integer fileSize;
	private String fileName;
	private Integer boardId;
	
	@Builder
	public File(int fileNo, String path, Date date, Integer fileSize, String fileName, Integer boardId) {
		super();
		this.fileNo = fileNo;
		this.path = path;
		this.date = date;
		this.fileSize = fileSize;
		this.fileName = fileName;
		this.boardId = boardId;
	}
	
	
}
