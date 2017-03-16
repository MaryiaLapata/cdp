package com.epam.cdp.userManagement.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.epam.cdp.userManagement.model.User;

@Service
public class UserStore {
	
	private List<User> userList;
	private Map<Long, User> userMap;
	
	public User addUserToList(User user) {
		long newId = generateId();
		
		user.setId(newId);
		userList.add(user);
		userMap.put(user.getId(), user);
		
		return user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
		userMap = new HashMap<>();
		
		for(User user : userList){
			userMap.put(user.getId(), user);
		}
	}

	public Map<Long, User> getUserMap() {
		return userMap;
	}
	
	private long generateId(){
		return userMap.entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .get().getKey() + 1;
	}
	
}
