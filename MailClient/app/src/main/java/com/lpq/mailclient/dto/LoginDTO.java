package com.lpq.mailclient.dto;


/**
 * @author Wei yuyaung
 * @date 2020.05.19 13:25
 */
public class LoginDTO {
    private String token;

    public LoginDTO() {
    }

    public LoginDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
