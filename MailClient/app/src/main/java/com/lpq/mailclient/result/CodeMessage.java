package com.lpq.mailclient.result;

/**
 * @author Wei yuyaung
 * @date 2020.05.19 12:21
 */
public class CodeMessage {
    /**
     * description: 成功时默认返回200
     * @author: Wei Yuyang
     * @time: 2020.01.29
     */
    public static final int CODE_SUCCESS = 200;
    /**
     * description: 字段校验错误默认返回1
     * @author: Wei Yuyang
     * @time: 2020.01.30
     */
    public static final int CODE_PARAM_ERROR = 1;

    public static final CodeMessage SYSTEM_ERROR = new CodeMessage(500,"系统错误");
    public static final CodeMessage ANDROID_NET_ERROR = new CodeMessage(502,"网络通信错误");
    public static final CodeMessage JSON_PARSE_ERROR = new CodeMessage(503,"json字段解析错误");
    public static final CodeMessage MAIL_SEND_ERROR = new CodeMessage(504,"邮件发送失败");

    private int code;
    private String message;

    public CodeMessage() {
    }

    public CodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
