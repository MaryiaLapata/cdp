package com.epam.cdp.userManagement.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.cdp.userManagement.model.User;
import com.epam.cdp.userManagement.service.IUserService;
import com.epam.cdp.userManagement.util.UserStore;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserStore userStore;
	
	@Override
	public List<User> getAll() {
		return userStore.getUserList();
	}

	@Override
	public User getById(long userId) {
		return userStore.getUserMap().get(userId);
	}

	@Override
	public User create(User newUser) {		
		return userStore.addUserToList(newUser);
	}

	@Override
	public User update(long id, User user) {
		Map<Long, User> userMap = userStore.getUserMap();
		User targetUser = userMap.get(id);
		
		targetUser.setAdress(user.getAdress());
		targetUser.setEmail(user.getEmail());
		targetUser.setFirstName(user.getFirstName());
		targetUser.setLastName(user.getLastName());
		targetUser.setPhone(user.getPhone());
		
		return targetUser;
	}
}
