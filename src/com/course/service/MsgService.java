package com.course.service;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.Msg;
import com.course.domain.SendMsg;

public class MsgService extends HibernateDaoSupport {

	private BaseDaoImpl<Msg> baseDao;
	private Msg msg;

	public BaseDaoImpl<Msg> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<Msg> baseDao) {
		this.baseDao = baseDao;
	}

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	/**
	 * 保存站内消息
	 * @param msg
	 */
	public void saveMsg(Msg msg) {
		System.out.println(msg.getMid());
		baseDao.save(msg);
	}

	/**
	 * 修改站内消息
	 * @param msg
	 */
	public void updateMsg(Msg msg) {
		System.out.println(msg.getMid());
		baseDao.update(msg);
	}
}
