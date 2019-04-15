package com.yet.spring.core.log;

public class ConsoleEventLogger implements EventLogger {
	
	public ConsoleEventLogger() {
	}
	
	public void logEvent(String message) {
		System.out.println(message);
	}

}
