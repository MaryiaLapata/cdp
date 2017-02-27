package com.epam.cdp.classloading;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.epam.cdp.classloading.components.BasicComponent;
import com.epam.cdp.classloading.interfaces.Resource;
import com.epam.cdp.classloading.utils.CustomClassloader;
import com.epam.cdp.classloading.utils.JarLoader;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyListener;

@SpringBootApplication
public class ClassloadingApp {
	
	public static final String LISTENED_FOLDER = "listenedFolder/";
	
	private static ConfigurableListableBeanFactory beanFactory;
	
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

		ConfigurableApplicationContext ctx = SpringApplication.run(ClassloadingApp.class, args);		
		beanFactory = ctx.getBeanFactory();
		System.out.println("This is my first Spring Boot Example");
		try {
			watchFiles();
		} catch (BeansException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private static void watchFiles() throws IOException, InterruptedException, ClassNotFoundException, BeansException, InstantiationException, IllegalAccessException{		
		Path faxFolder = Paths.get(LISTENED_FOLDER);
		CustomClassloader customClassLoader = new CustomClassloader(Thread.currentThread().getContextClassLoader());
		WatchService watchService = FileSystems.getDefault().newWatchService();
		faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		String fileName = "";
		boolean valid = true;
		
		
		do {
			WatchKey watchKey = watchService.take();

			for (WatchEvent event : watchKey.pollEvents()) {
				if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
					fileName = event.context().toString();
					System.out.println("File Created:" + fileName);
					
					if(fileName.endsWith(".jar") || fileName.endsWith(".zip")){
						List<Class>  classes = JarLoader.loadClasses(LISTENED_FOLDER + "/" + fileName);					
						registerBeabs(classes);
					} else {
						try(Stream<Path> paths = Files.walk(Paths.get(LISTENED_FOLDER + "/" + fileName))) {
							List<Class>  classes = new ArrayList<>();
							
						    paths.forEach(filePath -> {
						        if (Files.isRegularFile(filePath)) {
						            System.out.println(filePath);
						            String className = filePath.toString().substring(LISTENED_FOLDER.length(), filePath.toString().length()-6);
								    className = className.replace('\\', '.');
								    byte[] data;
								    System.out.println("app className: " + className);
									try {
										data = Files.readAllBytes(filePath);									
										Class result = customClassLoader.loadClass(className, data);
										classes.add(result);
									} catch (ClassNotFoundException | IOException e) {
										e.printStackTrace();
									}
						        }
						    });
						    
						    registerBeabs(classes);
						} 
					}
					
					
					
				}
			}
			valid = watchKey.reset();

		} while (valid);
		
		watchService.close();
		System.out.println("Watch service closed.");
	}

	private static void registerBeabs(List<Class> classes) throws BeansException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		for(Class clazz : classes){
			System.out.println("Register class: " + clazz);
			beanFactory.registerSingleton(clazz.getName(), clazz.newInstance());			
		}
	}
}
