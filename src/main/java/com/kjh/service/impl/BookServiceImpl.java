package com.kjh.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kjh.dao.BookDao;
import com.kjh.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Inject
	BookDao bookDao;
	
	@Override
	public String insert(Map<String, Object> map) {
		return this.bookDao.insert(map);
	}

	@Override
	public Map<String, Object> select(Map<String, Object> map) {
		return this.bookDao.select(map);
	}

	@Override
	public boolean update(Map<String, Object> map) {
		return this.bookDao.update(map);
	}

	@Override
	public boolean delete(Map<String, Object> map) {
		return this.bookDao.delete(map);
	}

	@Override
	public List<Map<String, Object>> list() {
		return this.bookDao.list();
	}
	

}
