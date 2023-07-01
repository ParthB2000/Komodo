package com.hlis.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hlis.exam.entity.User;

@Service
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment environment;
	
	public void sendSimpleEmail(String token, User user, Integer otp)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(environment.getProperty("spring.mail.username"));
		message.setTo(user.getEmail());
		message.setText("Your otp for verification "+otp+
				
						" Token is "+token+
				
						" Verification Link  "+"http://localhost:8081/register/varify?id="+user.getId());
		message.setSubject("Registration Link");
		
		mailSender.send(message);
	}
	
	public void sendLoginOtpMail(User user, Integer otp)
	{
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom(environment.getProperty("spring.mail.username"));
		message.setTo(user.getEmail());
		message.setText("Your otp for verification "+otp+ 
						" Verification Link  "+"http://localhost:8081/login/verify?id="+user.getId());
		message.setSubject("Otp For Login");
		
		mailSender.send(message);
	}
}
