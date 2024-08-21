package com.email.Config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configurable
@PropertySource("classPath:application.properties")  
public class AppConfig {
	
	@Value("${spring.mail.host}")
	private String mailhost;         // mail ka hosting ko decralre
	
	@Value("${spring.mail.port}")
	private String MailPort;            //mail ka port kitna hoga 
	
	@Value("${spring.mail.username}")
	private String MailUserName;
	
	@Value("${spring.mail.password}")
	private String MailPassword;
	
	@Bean
	public  JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSender= new JavaMailSenderImpl();
		javaMailSender.setHost(mailhost);
		javaMailSender.setPort(Integer.parseInt(MailPort));
		javaMailSender.setUsername(MailUserName);
		javaMailSender.setPassword(MailPassword);
		
		Properties props=javaMailSender.getJavaMailProperties();
		props.put("mail.smtp.stratts.enable", "true");
		return javaMailSender;
		
		
		
	}


}
