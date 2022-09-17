package com.oagsate.hibroserver.domain;

import lombok.Data;

@Data
public class Journal {
    private Integer id;
    private String content;
    private String createTime;
    private String updateTime;
    private int uid;
    private String brief;
    private String title;
}
