package com.yet.spring.core.spring;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yet.spring.core.bean.Client;

@Configuration
public class AppConfig {
	
	@Bean
	public Date newDate() {
		return new Date();
	};
	
	@Bean
	public DateFormat dateFormat() {
		return DateFormat.getDateTimeInstance();
	};
	
	@Bean
	public Client client() {
		Client client = new Client();
		client.setId("1");
		client.setName("Name");
		return client;
	}

}
