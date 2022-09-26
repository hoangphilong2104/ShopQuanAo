package com.hcmue.shop.services;

import java.util.List;

public interface Services<T>{
	List<T> listAll();
	List<T> listById(int id);
	List<T> listByName(String name);
	T findOne(int id);
	void save(T t);
	void delete(int id);
}
