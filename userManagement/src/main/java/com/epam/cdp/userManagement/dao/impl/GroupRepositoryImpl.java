package com.epam.cdp.userManagement.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.cdp.userManagement.dao.GroupRepository;
import com.epam.cdp.userManagement.dao.helper.GroupRowMapper;
import com.epam.cdp.userManagement.model.Group;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

	private String SQL_SELECT = "SELECT * FROM group WHERE group_id=?";
	private String SQL_SELECT_ALL = "SELECT * FROM group";
	private String SQL_DELETE = "DELETE FROM group WHERE group_id=?";
	private String SQL_UPDATE = "update group set name=? WHERE group_id=?";
	private String SQL_INSERT = "INSERT INTO group(name) VALUES (:name)";
	private String SQL_ADD_USER = "INSERT INTO user_group(user_id, group_id) VALUES (?,?)";
	private String SQL_ADD_PERMISSION = "INSERT INTO group_permission(group_id, permission_id) VALUES (?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public long create(Group entity) {
		SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(entity);
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    namedParameterJdbcTemplate.update(SQL_INSERT, fileParameters, keyHolder);
	    return keyHolder.getKey().intValue();
	}

	@Override
	public Group getById(long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT,
                new GroupRowMapper(), id);
	}

	@Override
	public int update(Group entity) {
		return jdbcTemplate.update(
				SQL_UPDATE,
				entity.getName(), entity.getId());
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update(
				SQL_DELETE,
				id);
	}

	@Override
	public List<Group> getAll() {
		return jdbcTemplate.query(SQL_SELECT_ALL,
                new GroupRowMapper());
	}

	@Override
	public void addUsers(long groupId, List<Long> userIds) {
		for(Long id : userIds) {
			jdbcTemplate.update(
					SQL_ADD_USER,
					id, groupId);
		}
	}

	@Override
	public void assignPermissions(long groupId, List<Long> permissionIds) {
		for(Long id : permissionIds) {
			jdbcTemplate.update(
					SQL_ADD_PERMISSION,
					groupId, id);
		}
	}

}
