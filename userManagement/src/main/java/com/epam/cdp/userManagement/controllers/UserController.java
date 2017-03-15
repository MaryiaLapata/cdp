package com.epam.cdp.userManagement.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping("/users")
    public List<Object> getUserList() {
		return null;
	}

	@RequestMapping("/users/{id}")
    public Object getUserDetails(@PathVariable("id") long id) {
		return null;
	}

	@RequestMapping(value="/users", method=RequestMethod.POST)
    public Object createUser(Object newUser) {
		return null;
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public Object updateUser(@PathVariable("id") long id, Object newUser) {
		return null;
	}
}
