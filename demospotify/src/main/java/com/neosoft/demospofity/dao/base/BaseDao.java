package com.neosoft.demospofity.dao.base;

import java.util.List;

public interface BaseDao<T> {

	void create(T entity);
	
	T save(T entity);
	
	void delete(T entity);
	
	void deleteById(Long id);
	
	T findById(Long id);
	
	List<T> getAll();
}
