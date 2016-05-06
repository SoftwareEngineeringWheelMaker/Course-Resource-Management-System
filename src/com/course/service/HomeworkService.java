package com.course.service;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.Homework;

import antlr.collections.List;

public class HomeworkService extends HibernateDaoSupport {

	private BaseDaoImpl<Homework> baseDao;
	private Homework homework;

	public BaseDaoImpl<Homework> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<Homework> baseDao) {
		this.baseDao = baseDao;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	/**
	 * 保存作业任务
	 */
	public void saveHomework(Homework homework) {
		baseDao.save(homework);
	}

	/**
	 * 修改作业任务
	 */
	public void updateHomework(Homework homework) {
		baseDao.update(homework);
	}

	/**
	 * 由id查询获取作业
	 */
	public Homework getHomework(Homework homework) {
		return baseDao.get(Homework.class, homework.getHid());
	}

}
