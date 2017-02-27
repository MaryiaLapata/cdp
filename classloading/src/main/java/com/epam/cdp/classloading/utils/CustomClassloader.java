package com.epam.cdp.classloading.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CustomClassloader extends ClassLoader {
	
	final ClassLoader parentClassLoader;
	
	private static Hashtable classes = new Hashtable(); 
	
	public CustomClassloader(ClassLoader parentClassLoader) {
		this.parentClassLoader = parentClassLoader;
	}
		
	public Class<?> loadClass(String className, byte classByte[]) throws ClassNotFoundException {		
		Class result = null;
		System.out.println("className: " + className);
		
		result = defineClass(className, classByte, 0, classByte.length, null);
        classes.put(className, result);
        return result;
	}
}
