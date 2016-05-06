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

@Table(name = "Resource")
@Entity
public class Resource implements Serializable {
	@Id
	@Column(name = "rid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rid;

	@Column(name = "rname", length = 30, nullable = false)
	private String rname;

	@Column(name = "rnewname", length = 30, nullable = false)
	private String rnewname;

	@Column(name = "rfileext", length = 10, nullable = false)
	private String rfileext;

	@Column(name = "rtime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date rtime = new Date();

	@ManyToOne()
	@JoinColumn(name = "cid", nullable = false)
	private Course course;

	@ManyToOne()
	@JoinColumn(name = "id", nullable = false)
	private User user;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRnewname() {
		return rnewname;
	}

	public void setRnewname(String rnewname) {
		this.rnewname = rnewname;
	}

	public String getRfileext() {
		return rfileext;
	}

	public void setRfileext(String rfileext) {
		this.rfileext = rfileext;
	}

	public Date getRtime() {
		return rtime;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
