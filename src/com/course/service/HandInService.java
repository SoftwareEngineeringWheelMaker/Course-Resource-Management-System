package com.course.service;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.HandIn;

public class HandInService extends HibernateDaoSupport {

	private BaseDaoImpl<HandIn> baseDao;
	private HandIn handIn;

	public BaseDaoImpl<HandIn> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<HandIn> baseDao) {
		this.baseDao = baseDao;
	}

	public HandIn getHandIn() {
		return handIn;
	}

	public void setHandIn(HandIn handIn) {
		this.handIn = handIn;
	}

	/**
	 * 保存提交作业信息
	 * @param handIn
	 */
	public void saveHandIn(HandIn handIn) {
		baseDao.save(handIn);
	}

	/**
	 * 修改提交作业信息
	 * @param handIn
	 */
	public void updateHandIn(HandIn handIn) {
		baseDao.update(handIn);
	}
}
