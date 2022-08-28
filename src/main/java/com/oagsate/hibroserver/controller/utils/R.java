package com.oagsate.hibroserver.controller.utils;

import lombok.Data;

@Data
public class R {
    private int code = 0;
    private Object data;
    private String message;

    public R() {
    }

    public R(int code) {
        this.code = code;
    }

    public R(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public R(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
