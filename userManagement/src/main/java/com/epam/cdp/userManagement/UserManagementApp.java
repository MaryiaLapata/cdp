package com.epam.cdp.userManagement;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epam.cdp.userManagement.model.Address;
import com.epam.cdp.userManagement.model.User;
import com.epam.cdp.userManagement.util.UserStore;

@SpringBootApplication
public class UserManagementApp {
	
	@Autowired
	public UserStore userStore;

	
	public UserManagementApp() {
        System.out.println("constructor of App");
    }

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApp.class, args);
	}
	
	@PostConstruct
	public void init() {
		List<User> users = new ArrayList<>();
		User user;
		Address address;
		
		for(int i = 1; i <= 10; i++){
			address = new Address(i, "Minsk", "Street" + i, i + 10, i*10);
			user = new User(i*100, "firstName" + i, "lastName" + i, "email" + i + "@dot.com", "1234567", address);
			
			users.add(user);
		}
		
		userStore.setUserList(users);
	}

}
