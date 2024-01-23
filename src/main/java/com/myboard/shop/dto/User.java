package com.myboard.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
	private String id;
	private String password;
	private Integer author;
	
	@Builder
	public User(String id, String password, Integer author) {
		super();
		this.id = id;
		this.password = password;
		this.author = author;
	}	
}
