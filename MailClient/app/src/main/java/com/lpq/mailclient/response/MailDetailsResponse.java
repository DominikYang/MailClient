package com.lpq.mailclient.response;

import com.lpq.mailclient.entity.MailInfo;

/**
 * @author Wei yuyaung
 * @date 2020.05.24 17:41
 */

public class MailDetailsResponse {
    private Integer code;
    private String message;
    private MailInfo data;

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

    public MailInfo getData() {
        return data;
    }

    public void setData(MailInfo data) {
        this.data = data;
    }
}
