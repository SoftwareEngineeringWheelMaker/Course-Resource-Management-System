package com.course.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames="no")})
@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // hibernate ID生成策略
	private Integer id;

	@Column(name = "no", length = 12, nullable = true)
	private String no;// 学号or教工号

	@Column(name = "name", length = 20)
	private String name;// 姓名

	@Column(name = "password", length = 16)
	private String password;// 密码
	
	@Column(name = "dept", length = 20, nullable = true)
	private String dept;// 学院
	
	@Column(name = "major", length = 20, nullable = true)
	private String major;// 专业
	
	@Column(name = "clazz", length = 20, nullable = true)
	private String clazz;// 班级
	private Integer type;// 角色 0-管理员，1-学生，2-教师
	private Integer status;// 状态 0-正常，1-停用，2-删除

	public User() {
	}

	public User(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
