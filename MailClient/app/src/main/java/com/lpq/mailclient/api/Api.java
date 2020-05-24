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

    /**
     * 修改昵称
     */
    public static final String CHANGE_NICK = BASE_URL + "user/change/nickname";

    /**
     * 修改密码
     */
    public static final String CHANGE_PSW = BASE_URL + "user/change/password" ;

    /**
     * 增加邮箱账户
     */
    public static final String ADD_ACCOUNT = BASE_URL + "user/addAccount" ;

    /**
     * description: 接收邮件 <br>
     * version: 1.0 <br>
     * date: 2020.05.23 22:27 <br>
     * author: Dominikyang <br>
     * 
     * @param null
     * @return 
     */ 
    public static final String RECEIVE_MAIL = BASE_URL + "mail/list";
    
    /**
     * description: 用户注册 <br>
     * version: 1.0 <br>
     * date: 2020.05.24 12:31 <br>
     * author: Dominikyang <br>
     * 
     * @param null
     * @return
     */ 
    public static final String REGESTER = BASE_URL + "user/register";
    
    /**
     * description: 邮件详情 <br>
     * version: 1.0 <br>
     * date: 2020.05.24 17:43 <br>
     * author: Dominikyang <br>
     * 
     * @param null
     * @return 
     */ 
    public static final String MAIL_DATAILS = BASE_URL + "mail/details";
}
