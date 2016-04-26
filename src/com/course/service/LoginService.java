package com.course.service;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.User;

public class LoginService extends HibernateDaoSupport{

	private BaseDaoImpl<User> baseDao;
	private User user;
	public BaseDaoImpl<User> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<User> baseDao) {
		this.baseDao = baseDao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	//保存用户
	public void saveUser(User user){
		System.out.println(user.getType());
		baseDao.save(user);
	}
	//判断用户名和密码是否与数据库匹配
	public boolean getUser(String name,String password){

		List<User> user=(List<User>)getHibernateTemplate().find("from User u where u.name=? and u.password=?", name,password);
		if(user.size()!=0)
			return true;
			else
				return false;
		}
	//判断用户名是否存在于数据库
	public boolean exist(String name){
		List<User> user=(List<User>)getHibernateTemplate().find("from User u where u.name=?", name);
		System.out.println(user.size());
		if(user.size()!=0)
		return false;
		else
			return true;
	}
}
