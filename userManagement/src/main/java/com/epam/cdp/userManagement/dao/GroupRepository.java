package com.epam.cdp.userManagement.dao;

import java.util.List;

import com.epam.cdp.userManagement.model.Group;

public interface GroupRepository extends EntityRepository<Group>{

	void addUsers(long groupId, List<Long> userIds);
	void assignPermissions(long groupId, List<Long> permissionIds);
}
