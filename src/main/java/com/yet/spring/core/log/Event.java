package com.yet.spring.core.log;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
	
	private int id;
	
	private String message;
	
	private Date date;
	
	private DateFormat dateFormat;

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
