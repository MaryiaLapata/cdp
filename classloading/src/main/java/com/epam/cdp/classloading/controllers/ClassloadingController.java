package com.epam.cdp.classloading.controllers;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.cdp.classloading.interfaces.Resource;

@RestController
public class ClassloadingController {

	@Autowired
	ConfigurableApplicationContext appContext;
	@Autowired
	ConfigurableListableBeanFactory beanFactory;
	
	@RequestMapping(value="/getBean", method=RequestMethod.GET)
	public String getCompoentByName(@RequestParam("name") String component) throws BeansException, ClassNotFoundException{
		// It finds Spring component by name using the one provided in request path. 
		System.out.println("Requested bean: " + component);
		
		//Listed all loaded bean
//		String[] beanNames = appContext.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

		
        Resource obj = (Resource)beanFactory.getBean(component);
		return obj.getData().toString();
	}
}
