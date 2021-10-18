package com.leshan.ebook.service;

public interface MailService {
    /**
     * 发送HTML邮件，方便用户点击附带的code用来验证激活账户
     * @param subject 邮箱主题
     * @param to  指定邮箱名
     * @param content 内容
     */
    void sendHtmlMail(String to, String subject, String content);
}
