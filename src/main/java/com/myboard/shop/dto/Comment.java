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
public class Comment {
	private int id;
	private String context;
	private Date date;
	private String writer;
	private String userId;
	private Integer boardId;
	
	@Builder
	public Comment(int id, String context, Date date, String writer, String userId, Integer boardId) {
		super();
		this.id = id;
		this.context = context;
		this.date = date;
		this.writer = writer;
		this.userId = userId;
		this.boardId = boardId;
	}
	
	
}
