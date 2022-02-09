package org.deanframework.starter.mail;

import org.deanframework.component.mail.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Dean
 */
@Configuration
public class MailAutoConfiguration {

    @Bean
    public MailSender getMailSender() {
        return new MailSender();
    }
}
