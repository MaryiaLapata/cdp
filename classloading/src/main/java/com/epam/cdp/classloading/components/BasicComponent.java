package com.epam.cdp.classloading.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.cdp.classloading.interfaces.Resource;

@Component
public class BasicComponent implements Resource {
	
	private List<String> data = new ArrayList<String>();
	
	{
		data.add(BasicComponent.class.getName());
		data.add(new Date().toString());
	}
	
	@Override
	public List<String> getData() {		
		return data;
	}

}
