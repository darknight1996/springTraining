package com.yet.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.core.bean.Client;
import com.yet.spring.core.log.Event;
import com.yet.spring.core.log.EventLogger;

public class App {
	
	private Client client;
	
	private EventLogger eventLogger;
	
	private static ApplicationContext ctx;
	
	public App(Client client, EventLogger eventLogger) {
		this.client = client;
		this.eventLogger = eventLogger;
	}
		
	public static void main(String[] args) {
		
		ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app = ctx.getBean(App.class);
				
		app.logEvent("1 said: \"You are not prepeared!\"");
	}
	
	private void logEvent(String message) {
		String processedMessage = message.replaceAll(client.getId(), client.getName());
		Event event = ctx.getBean(Event.class);
		event.setMessage(processedMessage);
		eventLogger.logEvent(event);
	}

}
