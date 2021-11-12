package com.kjh.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	String insert(Map<String, Object> map);
	
	Map<String, Object> select(Map<String, Object> map);
	
	boolean update(Map<String, Object> map);
	
	boolean delete(Map<String, Object> map);
	
	List<Map<String, Object>> list();
	
}
