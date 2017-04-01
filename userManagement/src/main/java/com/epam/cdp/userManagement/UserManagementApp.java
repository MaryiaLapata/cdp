package com.epam.cdp.userManagement;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import com.epam.cdp.userManagement.config.ApplicationConfig;
import com.epam.cdp.userManagement.config.ApplicationProperties;
import com.epam.cdp.userManagement.listener.ApplicationStartingListener;
import com.epam.cdp.userManagement.listener.HelloApplicationListener;
import com.epam.cdp.userManagement.model.Address;
import com.epam.cdp.userManagement.model.User;
import com.epam.cdp.userManagement.util.UserStore;

@SpringBootApplication
//@EnableConfigurationProperties(ApplicationProperties.class)
@Import(ApplicationConfig.class)
public class UserManagementApp {
	
	@Autowired
	public ApplicationProperties properties;

	
	public UserManagementApp() {
        System.out.println("constructor of App");
    }

	public static void main(String[] args) {
		//SpringApplication.run(UserManagementApp.class, args);
		new SpringApplicationBuilder(UserManagementApp.class)
		.listeners(new ApplicationStartingListener(), new HelloApplicationListener())
		.run(args);
	}
	
	@PostConstruct
	public void init() {
		System.out.println(properties.toString());
	}

}
