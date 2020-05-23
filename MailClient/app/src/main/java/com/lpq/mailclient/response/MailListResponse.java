package com.lpq.mailclient.response;

import com.lpq.mailclient.entity.MailInfo;

import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.05.23 22:35
 */
public class MailListResponse {
    private Integer code;
    private String message;
    private List<MailInfo> data;

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

    public List<MailInfo> getData() {
        return data;
    }

    public void setData(List<MailInfo> data) {
        this.data = data;
    }
}
