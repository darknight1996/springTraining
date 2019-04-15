package com.yet.spring.core;

import com.yet.spring.core.bean.Client;
import com.yet.spring.core.log.ConsoleEventLogger;
import com.yet.spring.core.log.EventLogger;

public class App {
	
	private Client client;
	
	private EventLogger eventLogger;
		
	public static void main(String[] args) {
		App app = new App();
		
		app.client = new Client("1", "Illidan Stormrage");
		app.eventLogger = new ConsoleEventLogger();
		
		app.logEvent("1 said: \"You are not prepeared!\"");
	}
	
	private void logEvent(String message) {
		String processedMessage = message.replaceAll(client.getId(), client.getName());
		eventLogger.logEvent(processedMessage);
	}

}
