package com.yet.spring.core.log;

import org.springframework.stereotype.Component;

import com.yet.spring.core.bean.Event;

@Component
public class ConsoleEventLogger implements EventLogger {
	
	public ConsoleEventLogger() {
	}
	
	public void logEvent(Event event) {
		System.out.println(event);
	}

}
