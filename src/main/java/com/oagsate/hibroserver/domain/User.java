package com.oagsate.hibroserver.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String createTime;
    private String lastTime;
    private int gender;
    private String birthday;
    private int status;
    private int orientation;
    private int height;
    private int weight;
    private int estatus;
    private int education;
    private int location;
    private String description;
    private String email;
}
