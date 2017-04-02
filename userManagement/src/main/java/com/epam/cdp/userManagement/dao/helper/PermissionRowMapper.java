package com.epam.cdp.userManagement.dao.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.cdp.userManagement.model.Permission;

public class PermissionRowMapper implements RowMapper<Permission> {

	@Override
	public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
		Permission permission = new Permission();
		permission.setId(rs.getInt("permission_id"));
		permission.setObject(rs.getString("object"));
		permission.setActionType(rs.getByte("action_type"));
		return permission;
	}

}
