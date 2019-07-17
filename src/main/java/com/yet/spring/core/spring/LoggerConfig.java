package com.yet.spring.core.spring;

import org.springframework.context.annotation.Configuration;

import com.yet.spring.core.log.EventLogger;
import javax.annotation.Resource;

@Configuration
public class LoggerConfig {
	
    @Resource(name = "consoleEventLogger")
    private EventLogger consoleEventLogger;

    @Resource(name = "fileEventLogger")
    private EventLogger fileEventLogger;

    @Resource(name = "cacheFileEventLogger")
    private EventLogger cacheEventLogger;

}
