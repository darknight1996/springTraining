package com.yet.spring.core;

public class App {
	
	private Client client;
	
	private ConsoleEventLogger consoleEventLogger;
	
	public static void main(String[] args) {
		App app = new App();
		
		app.client = new Client("1", "Illidan Stormrage");
		app.consoleEventLogger = new ConsoleEventLogger();
		
		app.logEvent("1 said: \"You are not prepeared!\"");
	}
	
	private void logEvent(String message) {
		String processedMessage = message.replaceAll(client.getId(), client.getName());
		consoleEventLogger.logEvent(processedMessage);
	}

}
