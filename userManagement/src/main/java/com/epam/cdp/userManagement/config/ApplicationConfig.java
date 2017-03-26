package com.epam.cdp.userManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.cdp.userManagement.service.IUserService;
import com.epam.cdp.userManagement.service.impl.UserServiceImpl;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public IUserService getBean() {
		return new UserServiceImpl();
	}

}
