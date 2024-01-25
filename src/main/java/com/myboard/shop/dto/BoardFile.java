package com.myboard.shop.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
<<<<<<< HEAD

=======
 
>>>>>>> origin/main+search
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardFile {
	private int fileNo;
	private String path;
	private Date date;
	private Integer fileSize;
	private String fileName;
	private Integer boardId;
	
	@Builder
	public BoardFile(int fileNo, String path, Date date, Integer fileSize, String fileName, Integer boardId) {
		super();
		this.fileNo = fileNo;
		this.path = path;
		this.date = date;
		this.fileSize = fileSize;
		this.fileName = fileName;
		this.boardId = boardId;
	}
	
	
}
