package com.lpq.mailclient.entity;


import java.io.Serializable;

/**
 * mail_account_info
 * @author 
 */
public class MailAccountInfo implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 邮箱账号
     */
    private String mailAccount;

    /**
     * 邮箱密码
     */
    private String mailPassword;

    /**
     * pop地址
     */
    private String mailPopAddress;

    /**
     * pop端口号
     */
    private String mailPopPort;

    /**
     * smtp地址
     */
    private String mailSmtpAddress;

    /**
     * smtp端口号
     */
    private String mailSmtpPort;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMailAccount() {
        return mailAccount;
    }

    public void setMailAccount(String mailAccount) {
        this.mailAccount = mailAccount;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public String getMailPopAddress() {
        return mailPopAddress;
    }

    public void setMailPopAddress(String mailPopAddress) {
        this.mailPopAddress = mailPopAddress;
    }

    public String getMailPopPort() {
        return mailPopPort;
    }

    public void setMailPopPort(String mailPopPort) {
        this.mailPopPort = mailPopPort;
    }

    public String getMailSmtpAddress() {
        return mailSmtpAddress;
    }

    public void setMailSmtpAddress(String mailSmtpAddress) {
        this.mailSmtpAddress = mailSmtpAddress;
    }

    public String getMailSmtpPort() {
        return mailSmtpPort;
    }

    public void setMailSmtpPort(String mailSmtpPort) {
        this.mailSmtpPort = mailSmtpPort;
    }
}