package com.example.demo.MailConfig;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by ahmed mar3y on 08/02/2018.
 */
public interface EmailService {
    void sendSimpleMessage(String to,
                           String subject,
                           String text);
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        SimpleMailMessage template,
                                        String ...templateArgs);
    void sendMessageWithAttachment(String to,
                                   String subject,
                                   String text,
                                   String pathToAttachment);
    void sendMessageWithHtml(String to,
                             String subject,
                             String text);
}
