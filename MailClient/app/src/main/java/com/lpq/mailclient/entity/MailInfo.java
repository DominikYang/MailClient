package com.lpq.mailclient.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * mail_info
 * @author 
 */
public class MailInfo implements Serializable {
    /**
     * 邮件id
     */
    private Integer id;

    /**
     * 邮件所属的用户
     */
    private Integer userId;

    /**
     * 主题
     */
    private String subject;

    /**
     * 发送方
     */
    private String from;

    /**
     * 接收方
     */
    private String to;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 邮件日期
     */
    private Date date;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MailInfo() {
    }

    public MailInfo(Integer id, Integer userId, String subject, String from, String to, String content, Date date) {
        this.id = id;
        this.userId = userId;
        this.subject = subject;
        this.from = from;
        this.to = to;
        this.content = content;
        this.date = date;
    }
}