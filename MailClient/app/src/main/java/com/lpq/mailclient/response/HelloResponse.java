package com.lpq.mailclient.response;

import com.lpq.mailclient.dto.LoginDTO;

/**
 * @author Wei yuyaung
 * @date 2020.05.20 22:34
 */
public class HelloResponse {
    private Integer code;
    private String message;
    private String data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
