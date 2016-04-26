package com.course.common.dao;
/**
 * 基本数据操作接口
 */
import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	T get(Class<T> entityClazz,Serializable id);
	Serializable save(T entity);
	void update(T entity);
	void delete(T entity);
	List<T> findAll(Class<T> entity);
	long findCount(Class<T> entityClazz);
}
