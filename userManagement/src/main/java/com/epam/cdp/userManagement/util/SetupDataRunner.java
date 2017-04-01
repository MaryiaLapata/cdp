package com.epam.cdp.userManagement.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epam.cdp.userManagement.model.Address;
import com.epam.cdp.userManagement.model.User;

@Component
public class SetupDataRunner implements CommandLineRunner{

	@Autowired
	public UserStore userStore;
	
	@Override
	public void run(String... args) throws Exception {
		List<User> users = new ArrayList<>();
		User user;
		Address address;
		
		for(int i = 1; i <= 10; i++){
			address = new Address(i, "Minsk", "Street" + i, i + 10, i*10);
			user = new User(i*100, "firstName" + i, "lastName" + i, "email" + i + "@dot.com", "1234567", address);
			
			users.add(user);
		}
		
		userStore.setUserList(users);
		
		System.out.println("Users were created");
		
	}

}
