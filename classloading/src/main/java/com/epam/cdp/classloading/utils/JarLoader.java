package com.epam.cdp.classloading.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLoader {

	
	public static List loadClasses(String pathToJar) throws ClassNotFoundException, IOException {
		List<Class> classesFromJar = new ArrayList();
		CustomClassloader customClassLoader = new CustomClassloader(Thread.currentThread().getContextClassLoader());
		byte classByte[];       
	        
		JarFile jarFile = new JarFile(pathToJar);
		Enumeration<JarEntry> e = jarFile.entries();		
		
		while (e.hasMoreElements()) {
		    JarEntry je = e.nextElement();
		    if(je.isDirectory() || !je.getName().endsWith(".class")){
		        continue;
		    }
		    
		    InputStream is = jarFile.getInputStream(je);
	        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
	        int nextValue = is.read();
	        while (-1 != nextValue) {
	            byteStream.write(nextValue);
	            nextValue = is.read();
	        }
	        String className = je.getName().substring(0,je.getName().length()-6);
		    className = className.replace('/', '.');
		    
	        classByte = byteStream.toByteArray();
	        Class result = customClassLoader.loadClass(className, classByte);
	       
		    
		    System.out.println("Loaded class: " + result);
		    classesFromJar.add(result);
		}

		return classesFromJar;
	}
}
