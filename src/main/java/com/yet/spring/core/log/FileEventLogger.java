package com.yet.spring.core.log;

import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yet.spring.core.bean.Event;

@Component
public class FileEventLogger implements EventLogger {
	
	@Value("app_log.log")
	private String fileName;
	
	private File file;
	
	public FileEventLogger() {
	}
	
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
	
	@PostConstruct
	public void init() throws IOException {
		this.file = new File(fileName);
		this.file.createNewFile();
		
		if (!this.file.canWrite()) {
			throw new IOException();
		}
	}

}
