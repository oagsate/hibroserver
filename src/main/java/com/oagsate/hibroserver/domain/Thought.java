package com.oagsate.hibroserver.domain;

import lombok.Data;

@Data
public class Thought {
    private Integer id;
    private String content;
    private String createTime;
    private int uid;
}
