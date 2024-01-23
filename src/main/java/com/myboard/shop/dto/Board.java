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
public class Board {
	private int fileNo;
	private String title;
	private String context;
	private Date regDate;
	private String writer;
	private String userId;
	private Date updateDate;
	
	@Builder
	public Board(int fileNo, String title, String context, Date regDate, String writer, String userId, Date updateDate) {
		super();
		this.fileNo = fileNo;
		this.title = title;
		this.context = context;
		this.regDate = regDate;
		this.writer = writer;
		this.userId = userId;
		this.updateDate = updateDate;
	}
	
	
}
