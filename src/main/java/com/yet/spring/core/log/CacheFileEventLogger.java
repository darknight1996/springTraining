package com.yet.spring.core.log;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
	
	private int size;
	
	private List<Event> cache;

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
	
	public void destroy() {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}
	
	

}
