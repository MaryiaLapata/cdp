package com.epam.cdp.userManagement.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class HelloApplicationListener implements ApplicationListener<ApplicationEvent>{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Recieved event: " + event.getClass().getName());
		
	}

}
