package com.yet.spring.core.log;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yet.spring.core.bean.Event;

@Component
public class CacheFileEventLogger extends FileEventLogger {
	
	@Value("1")
	private int size;
	
	private List<Event> cache;
	
	public CacheFileEventLogger(){
	}

	public CacheFileEventLogger(String fileName, int size) {
		super(fileName);
		this.size = size;
		cache = new ArrayList<Event>(size);
	}

	@Override
	public void logEvent(Event event) {
		cache.add(event);
		if (size == cache.size()) {
			writeEventsFromCache();
			cache.clear();
		}	
	}
	
	private void writeEventsFromCache() {
		for (Event e: cache) {
			super.logEvent(e);
		}	
	}
	
    @PostConstruct
    public void initCache() {
        this.cache = new ArrayList<Event>(size);
    }
	
	@PreDestroy
	public void destroy() {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}
	
	

}
