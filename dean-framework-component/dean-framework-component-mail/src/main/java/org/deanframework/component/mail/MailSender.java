package org.deanframework.component.mail;

import org.deanframework.component.mail.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;

/**
 * @auther Dean
 */
public class MailSender {

    @Autowired
    private MailUtil mailUtil;

    /**
     * 简单文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        mailUtil.sendSimpleMail(to, subject, content);
    }

    /**
     * html邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        mailUtil.sendHtmlMail(to, subject, content);
    }

    /**
     * 带附件的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     */
    public void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException {
        mailUtil.sendAttachmentMail(to, subject, content, filePath);
    }
}
