package com.ing.tmrbank.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendOTPEmail(String emailId, Long otp) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("ING BANk OTP verification mail!!");
		
		mail.setText("The OTP for adding/editing beneficiary is" + " " + otp);
		javaMailSender.send(mail);
	}
	
	public void sendStatusEmail(String emailId, String subject) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailId);
		mail.setSubject("ING BANk Account verification mail!!");
		
		mail.setText("The Payee for adding Beneficiary is");
		javaMailSender.send(mail);
	}
}