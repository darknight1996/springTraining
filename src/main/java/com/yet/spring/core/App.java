package com.yet.spring.core;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.yet.spring.core.bean.Client;
import com.yet.spring.core.bean.Event;
import com.yet.spring.core.log.EventLogger;
import com.yet.spring.core.spring.AppConfig;
import com.yet.spring.core.spring.LoggerConfig;

@Service
public class App {
	
	@Autowired
	private Client client;
	
	@Resource(name="cacheFileEventLogger")
	private EventLogger eventLogger;
	
	private static AnnotationConfigApplicationContext ctx;
	
	public App() {
	}
	
	public App(Client client, EventLogger eventLogger) {
		this.client = client;
		this.eventLogger = eventLogger;
	}
		
	public static void main(String[] args) {
		
		ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class, LoggerConfig.class);
        ctx.scan("com.yet.spring.core");
        ctx.refresh();
		
		App app = ctx.getBean(App.class);
		
		
				
		app.logEvent("1 said: \"You are not prepeared!\"");
	}
	
	private void logEvent(String message) {
		String processedMessage = message.replaceAll(client.getId(), client.getName());
		Event event = ctx.getBean(Event.class);
		event.setMessage(processedMessage);
		eventLogger.logEvent(event);
		
		ctx.close();
	}
		
}
