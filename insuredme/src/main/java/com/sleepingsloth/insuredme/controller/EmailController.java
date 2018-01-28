package com.sleepingsloth.insuredme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/email")
public class EmailController {
	
	@Autowired
	private JavaMailSender  javaMailSender;

	@GetMapping(path="/send")
	public @ResponseBody void sendEmail(@RequestParam String email) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 	
        message.setSubject("Test"); 
        message.setText("Thank you for becoming part of our family!");
        javaMailSender.send(message);
		
	}
}
