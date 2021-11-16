package main.java.biz.board;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private int cnt;

    private String searchCondition;
    private String searchKeyword;
}
