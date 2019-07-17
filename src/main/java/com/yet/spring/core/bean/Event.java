package com.yet.spring.core.bean;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Event {
	
	private int id;
	
	private String message;
	
	@Autowired
	@Qualifier("newDate")
	private Date date;
	
	@Autowired
	@Qualifier("dateFormat")
	private DateFormat dateFormat;
	
	public Event() {
	}

	public Event(Date date, DateFormat dateFormat) {
		generateUniqId();
		this.date = date;
		this.dateFormat = dateFormat;
	}
	
	private void generateUniqId() {
		Random random = new Random();
		this.id = random.nextInt();
	}
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", message=" + message + ", date=" + dateFormat.format(date) + "]";
	}

}
