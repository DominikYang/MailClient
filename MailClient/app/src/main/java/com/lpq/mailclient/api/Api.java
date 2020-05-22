package com.lpq.mailclient.api;

/**
 * @author Wei yuyaung
 * @date 2020.05.20 17:22
 */
public class Api {
    public static final String BASE_URL = "http://192.168.43.1:8080/api/v1/";

    /**
     * description: 测试连接
     * @author: Wei Yuyang
     * @time: 2020.05.20
     */
    public static final String HELLO = BASE_URL + "hello";

    /**
     * description: 登录
     * @author: Wei Yuyang
     * @time: 2020.05.20
     */
    public static final String LOGIN = BASE_URL + "user/login";

    /**
     * description: 获取当前用户绑定的邮箱
     * @author: Wei Yuyang
     * @time: 2020.05.21
     */
    public static final String USER_MAIL_ACCOUNT = BASE_URL + "user/info/accounts";
    
    /**
     * description:
     * @author: Wei Yuyang
     * @time: 2020.05.21
     */
    public static final String SEND_EMAIL = BASE_URL + "mail/send";
}
