package com.course.service;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.SendMsg;

public class SendMsgService extends HibernateDaoSupport {

	private BaseDaoImpl<SendMsg> baseDao;
	private SendMsg sendMsg;

	public BaseDaoImpl<SendMsg> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<SendMsg> baseDao) {
		this.baseDao = baseDao;
	}

	public SendMsg getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(SendMsg sendMsg) {
		this.sendMsg = sendMsg;
	}

	// 保存发送消息
	public void saveSendMsg(SendMsg sendMsg) {
		baseDao.save(sendMsg);
	}

	// 修改发送消息
	public void updateSendMsg(SendMsg sendMsg) {
		baseDao.update(sendMsg);
	}
}
