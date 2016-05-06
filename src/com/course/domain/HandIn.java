package com.course.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "HandIn")
@Entity
public class HandIn implements Serializable {
	@Id
	@Column(name = "hiid")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // hibernate ID生成策略
	private Integer hiid;

	@Column(name = "hiname", length = 30, nullable = false)
	private String hiname;

	@Column(name = "hinewname", length = 30, nullable = false)
	private String hinewname;

	@Column(name = "hifileext", length = 10, nullable = true)
	private String hifileext;

	@Column(name = "hitime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date hitime = new Date();
	
	@Column(name = "hievaluate", length = 100, nullable = true)
	private String hievaluate;

	@ManyToOne()
	@JoinColumn(name = "hid")
	private Homework homework;

	@ManyToOne()
	@JoinColumn(name = "id")
	private User user;

	public Integer getHiid() {
		return hiid;
	}

	public void setHiid(Integer hiid) {
		this.hiid = hiid;
	}

	public String getHiname() {
		return hiname;
	}

	public void setHiname(String hiname) {
		this.hiname = hiname;
	}

	public String getHinewname() {
		return hinewname;
	}

	public void setHinewname(String hinewname) {
		this.hinewname = hinewname;
	}

	public String getHifileext() {
		return hifileext;
	}

	public void setHifileext(String hifileext) {
		this.hifileext = hifileext;
	}

	public Date getHitime() {
		return hitime;
	}

	public void setHitime(Date hitime) {
		this.hitime = hitime;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
