package com.myboard.shop.dto;
import lombok.Builder;
import lombok.Data;

@Data
public class PageRequest {

  // 현재 페이지 번호
  private int pageNum;

  // 페이지당 출력할 데이터 개수
  private int amount;
  
  // 검색 키워드
  private String searchKeyword;

  public PageRequest() {
    this(1, 10);
  }

  public PageRequest(int pageNum, int amount) {
    super();
    this.pageNum = pageNum;
    this.amount = amount;
  }
  
  // 추가
  @Builder
  public PageRequest(int pageNum, int amount, String searchKeyword) {
    super();
    this.pageNum = pageNum;
    this.amount = amount;
    this.searchKeyword = searchKeyword;
  }

}