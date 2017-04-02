package com.epam.cdp.userManagement.service;

import java.util.List;

import com.epam.cdp.userManagement.model.User;

public interface IUserService {

	List<User> getAll();
	
	User getById(long userId);
	
	long create(User newUser);
	
	User update(long id, User newUser);
	
	void delete(long id);
}
