package com.epam.cdp.userManagement.dao.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.cdp.userManagement.model.Group;

public class GroupRowMapper implements RowMapper<Group> {

	@Override
	public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
		Group group = new Group();
		group.setId(rs.getInt("group_id"));
		group.setName(rs.getString("name"));
		return group;
	}

}
