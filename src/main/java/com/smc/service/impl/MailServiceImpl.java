package com.smc.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.smc.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	
	@Value("${spring.mail.maillink}")
	private String maillink;
	  
	
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * a发送简单文本文件 for test
     */
    public void sendSimpleEmail(){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("yolanda@163.com");
            message.setTo("xuexp@cn.ibm.com");
            message.setSubject("hello");
            message.setText("helloha");
            message.setCc("yolanda@163.com");
            mailSender.send(message);

        }catch (Exception e){
        	e.printStackTrace();
            System.out.println("发送简单文本文件-发生异常"+e);
        }
    }

    /**
     * a发送html文本
     * @param
     * @throws MessagingException 
     */
    @Async
    public void sendHTMLMail(String email, String username) throws MessagingException{
    
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("yolanda@163.com");
            messageHelper.setTo(email);
            messageHelper.setCc("yolanda@163.com");
            messageHelper.setSubject("Welcome to SMC system");
            messageHelper.setText("<a href='"+ maillink + username + "'>please click here to confirm your sign up!</a>", true);
            mailSender.send(mimeMessage);
            System.out.println("发送html文本文件-成功");
    }
    
    /**
     * a发送new password
     */
    public void sendNewPasswordEmail(String email, String newpassword){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("yolanda@163.com");
            message.setTo(email);
            message.setSubject("Your New Password to Login SMC System");
            message.setText("Your New Password >>>> "+ newpassword);
            message.setCc("yolanda@163.com");
            mailSender.send(message);

    }
    
    
}
