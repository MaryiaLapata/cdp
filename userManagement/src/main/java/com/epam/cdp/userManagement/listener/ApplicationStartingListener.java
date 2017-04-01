package com.epam.cdp.userManagement.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent>{

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("ApplicationStartingEvent: " + event.getClass().getName());
	}

}
