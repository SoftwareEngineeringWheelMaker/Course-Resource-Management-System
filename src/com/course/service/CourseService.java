package com.course.service;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.course.common.dao.impl.BaseDaoImpl;
import com.course.domain.Course;

public class CourseService extends HibernateDaoSupport {

	private BaseDaoImpl<Course> baseDao;
	private Course course;

	public BaseDaoImpl<Course> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl<Course> baseDao) {
		this.baseDao = baseDao;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * 保存课程信息
	 */
	public void saveCourse(Course course) {
		baseDao.save(course);
	}

	/**
	 * 修改课程信息
	 */
	public void updateCourse(Course course) {
		baseDao.update(course);
	}
}
