package com.email.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.DTO.EmailDto;

@RestController
public class Controller {
@Autowired	
private JavaMailSender javaMailSender;
@PostMapping("/sendEmail")
 public String sendEmail(@RequestBody EmailDto emaildto) {
	 
	 SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
	 simpleMailMessage.setTo(emaildto.getTo());
	 simpleMailMessage.setSubject(emaildto.getSubject());
	 simpleMailMessage.setText(emaildto.getText());
	 javaMailSender.send(simpleMailMessage);
	 
	  return "Email send succesfully";
 }

}
