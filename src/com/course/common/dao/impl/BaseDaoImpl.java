package com.course.common.dao.impl;
/**
 * 基本数据操作的具体实现
 */
import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.course.common.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entity) {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().find("from ?",entity.getSimpleName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public long findCount(Class<T> entity) {
		// TODO Auto-generated method stub
		 List<Long> list = (List<Long>)getHibernateTemplate().find("select count(*) from ?",entity.getSimpleName());
		 return list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql,int pageNo, int pageSize){
		List<T> list = (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				List<T> result = session.createQuery(hql).setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql,int pageNo, int pageSize ,Object...params){
		List<T> list = (List<T>) getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@Override
			public List<T> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query =  session.createQuery(hql);
				for(int i = 0; i<params.length ; i++){
					query.setParameter(i, params[i]);
				}
				List<T> result = query.list();
				return result;
			}
		});
		return list;
	}
}
