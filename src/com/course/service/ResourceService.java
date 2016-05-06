package com.course.service;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.Resource;

public class ResourceService extends HibernateDaoSupport {

	private BaseDaoImpl<Resource> baseDao;
	private Resource resource;

	public BaseDaoImpl<Resource> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<Resource> baseDao) {
		this.baseDao = baseDao;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	/**
	 * 保存上传课程资源信息
	 * @param resource
	 */
	public void saveResource(Resource resource) {
		baseDao.save(resource);
	}

	/**
	 * 修改上传课程资源信息
	 * @param resource
	 */
	public void updateResource(Resource resource) {
		baseDao.update(resource);
	}

}
