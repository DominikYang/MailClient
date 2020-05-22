package com.lpq.mailclient.response;

import com.lpq.mailclient.entity.MailAccountInfo;
import com.lpq.mailclient.entity.MailInfo;

import java.util.List;

/**
 * @author Wei yuyaung
 * @date 2020.05.21 12:47
 */
public class MailAccountInfoResponse {
    Integer code;
    String message;
    List<MailAccountInfo> data;

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

    public List<MailAccountInfo> getData() {
        return data;
    }

    public void setData(List<MailAccountInfo> data) {
        this.data = data;
    }
}
