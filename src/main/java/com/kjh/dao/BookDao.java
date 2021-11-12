package com.kjh.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Inject
	SqlSessionTemplate sqlSessionTemplate;
	
	public String insert(Map<String, Object> map) {
		this.sqlSessionTemplate.insert("book.insert", map);
		String bookId = map.get("bookId").toString();
		return bookId;
	}
	
	public Map<String, Object> select(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("book.select", map);
	}
	
	public boolean update(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.update("book.update", map);
		return result > 0;
	}
	
	public boolean delete(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.delete("book.delete", map);
		return result > 0;
	}
	
	public List<Map<String, Object>> list() {
		return this.sqlSessionTemplate.selectList("book.list");
	}
}
