package com.epam.cdp.userManagement.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class ApplicationProperties {
	
	private String main;
	
	private String error;

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ApplicationProperties: main: " + main + ", error: " + error;
	}
}
