package com.lpq.mailclient.response;

import com.lpq.mailclient.dto.LoginDTO;

/**
 * @author Wei yuyaung
 * @date 2020.05.20 19:34
 */
public class LoginResponse {
    private Integer code;
    private String message;
    private LoginDTO data;

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

    public LoginDTO getData() {
        return data;
    }

    public void setData(LoginDTO data) {
        this.data = data;
    }
}
