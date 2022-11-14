package com.myapp.springawsses.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springawsses.config.AwsPropertyConfig;
import com.myapp.springawsses.entity.Mail;
import com.myapp.springawsses.service.MailService;

@RestController
public class MailController {

	private MailService mailService;
	private AwsPropertyConfig awsPropertyConfig;

	public MailController(MailService emailSenderService, AwsPropertyConfig customPropertyConfig) {
		this.mailService = emailSenderService;
		this.awsPropertyConfig = customPropertyConfig;
	}

	@GetMapping(value = "/send")
	public String sendMail() throws MessagingException {
		Mail mail = getMail();
		mailService.sendEmail(mail);
		return "Check your email";

	}

	private Mail getMail() {
		Mail mail = new Mail();
		mail.setFrom(awsPropertyConfig.mailFrom);
		mail.setTo("youremail@gmail.com");
		mail.setSubject("Simple mail");
		Map<String, Object> model = new HashMap<>();
		model.put("templateVariable", "Simple mail with aws..");
		mail.setModel(model);
		return mail;

	}
}
