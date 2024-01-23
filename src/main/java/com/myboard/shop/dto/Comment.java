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
	private String user_id;
	private String board_id;
	
	@Builder
	public Comment(int id, String context, Date date, String writer, String user_id, String board_id) {
		super();
		this.id = id;
		this.context = context;
		this.date = date;
		this.writer = writer;
		this.user_id = user_id;
		this.board_id = board_id;
	}
	
	
}
