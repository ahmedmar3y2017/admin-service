package com.example.demo.MailConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {


    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;


    }

    public void SendNotification(String to, String subject, String text) {

        // send Mail
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("ahmedmar3y108@gmail.com");
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);


    }

    public void sendMessageWithAttachment(
            String to, String subject, String text, String pathToAttachment) {


        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file
                    = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


        javaMailSender.send(message);

    }



/*
 * 
 * to use it ................
 * 
 *     @Autowired
    NotificationService NotificationService;
    @RequestMapping(value = "/mail")
    public void sendMail() {
    	
    	System.out.println("Done   .....................");
    	// create User
    	Users users=new Users();
    	users.setUsername("ahmed");
    	users.setPassword("3091996");
    	users.setEmail("ahmedmar3y108108@gmail.com");

  try
  {
	  
	    NotificationService.SendNotification(users); 
  }catch(Exception exception) {
	  
	  logger.info("Error ..... "+exception.getMessage());
	  
  }
    }
 * 
 * 
 * 
 * 
 * */
}
