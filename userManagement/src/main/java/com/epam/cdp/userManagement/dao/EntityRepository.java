package com.epam.cdp.userManagement.dao;

import java.util.List;

public interface EntityRepository<T> {
	
	long create(T entiry);
	T getById(long id);
	int update(T entity);
	void delete(long id);
	
	List<T> getAll();

}
