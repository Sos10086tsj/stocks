package com.chinesedreamer.stocks.message.mail.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailConfig {
	public static final String propertyName = "message-config.properties";
	
	public static Properties loadConfig() throws IOException {
		InputStream is = EmailConfig.class.getClassLoader().getResourceAsStream(propertyName);
		Properties prop = new Properties();
		prop.load(is);
		return prop;
	}
}
