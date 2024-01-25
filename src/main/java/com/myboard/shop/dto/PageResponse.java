package com.myboard.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponse {

  // 화면 하단 출력할 페이지 개수(기본 : 10)
    private int pageAmount;

    // 화면 시작/종료 페이지 번호
    private int startPage, endPage;

    // 이전/다음 페이지 이동
    private boolean prev, next;

    // 실제 마지막 페이지 번호
    private int realEnd;

    // 전체 페이지 개수(<- db : COUNT)
    private int total;

    private PageRequest pageRequest;

    public PageResponse(){}

    @Builder
    public PageResponse(int total, int pageAmount, PageRequest pageRequest) {
        this.total = total;
        this.pageAmount = pageAmount;
        this.pageRequest = pageRequest;
        
        this.endPage = (int)(Math.ceil(pageRequest.getPageNum() * 1.0 / pageAmount)) * pageAmount;
        this.startPage = endPage - (pageAmount - 1);

        realEnd = (int)(Math.ceil(total * 1.0 / pageRequest.getAmount()));

        if(endPage > realEnd){
          this.endPage = realEnd;
        }

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}