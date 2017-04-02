package com.epam.cdp.userManagement.dao.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.epam.cdp.userManagement.model.Address;

public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address = new Address();
		address.setId(rs.getInt("address_id"));
        address.setCity(rs.getString("city"));
        address.setStreet(rs.getString("street"));
        address.setFlatNumber(rs.getInt("flat_number"));
        address.setHouseNumber(rs.getInt("house_number"));
		return address;
	}

}
