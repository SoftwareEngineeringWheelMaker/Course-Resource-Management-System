package com.course.service;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.Notice;

public class NoticeService extends HibernateDaoSupport {

	private BaseDaoImpl<Notice> baseDao;
	private Notice notice;

	public BaseDaoImpl<Notice> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<Notice> baseDao) {
		this.baseDao = baseDao;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	/**
	 * 保存公告信息
	 * @param notice
	 */
	public void saveNotice(Notice notice) {
		baseDao.save(notice);
	}

	/**
	 * 修改公告信息
	 * @param notice
	 */
	public void updateNotice(Notice notice) {
		baseDao.update(notice);
	}

}
