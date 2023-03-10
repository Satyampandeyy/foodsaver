package com.food.saver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PropertiesConfigLoader {

	@Autowired
	private Environment env;
	
	public String getConfigValue(String key) {
		return env.getProperty(key);
	}
}
