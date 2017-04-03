package com.epam.cdp.userManagement.dao;

import java.util.List;

import com.epam.cdp.userManagement.model.User;

public interface UserRepository extends EntityRepository<User>{
	
	void assignPermissions(long userId, long[] permissionIds);
}
