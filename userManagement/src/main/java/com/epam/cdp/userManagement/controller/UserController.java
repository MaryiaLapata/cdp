package com.epam.cdp.userManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.cdp.userManagement.model.User;
import com.epam.cdp.userManagement.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User> getUserList() {
		return userService.getAll();
	}

	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public User getUserDetails(@PathVariable("id") long id) {
		return userService.getById(id);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
		userService.delete(id);
	}

	@RequestMapping(value="/users", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public long createUser(@RequestBody User newUser) {
		return userService.create(newUser);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable("id") long id, @RequestBody User newUser) {
		newUser.setId(id);
		return userService.update(id, newUser);
	}
}
