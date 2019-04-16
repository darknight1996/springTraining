package com.yet.spring.core.log;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {
	
	private String fileName;
	
	private File file;
	
	public FileEventLogger(String fileName) {
		this.fileName = fileName;
	}

	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(this.file, event.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws IOException {
		this.file = new File(fileName);
		
		if (!this.file.canWrite()) {
			throw new IOException();
		}
	}

}
