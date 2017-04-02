package com.epam.cdp.userManagement.dao.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.cdp.userManagement.model.Address;
import com.epam.cdp.userManagement.model.User;

public class UserRowMapper implements RowMapper<User>{
	
	private AddressRowMapper addressRowMapper = new AddressRowMapper();

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		Address address = addressRowMapper.mapRow(rs, rowNum);
        user.setId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setAddress(address);
        return user;
	}

}
