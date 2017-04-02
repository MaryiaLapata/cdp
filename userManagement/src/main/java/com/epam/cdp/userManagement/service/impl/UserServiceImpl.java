package com.epam.cdp.userManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.epam.cdp.userManagement.dao.EntityRepository;
import com.epam.cdp.userManagement.dao.UserRepository;
import com.epam.cdp.userManagement.model.Address;
import com.epam.cdp.userManagement.model.User;
import com.epam.cdp.userManagement.service.IUserService;


public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EntityRepository<Address> addressRepository;
	
	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public User getById(long userId) {
		return userRepository.getById(userId);
	}

	@Override
	public long create(User newUser) {	
		long addressId = addressRepository.create(newUser.getAddress());
		newUser.getAddress().setId(addressId);
		return userRepository.create(newUser);
	}

	@Override
	public User update(long id, User user) {
		user.setId(id);
		
		if(userRepository.update(user) > 0) {
			return userRepository.getById(id);
		}
		
		return null;
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
		
	}
}
