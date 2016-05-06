package com.course.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Course")
@Entity
public class Course implements Serializable {
	@Id
	@Column(name = "cid")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // hibernate ID生成策略
	private Integer cid;

	@Column(name = "cname", length = 30)
	private String cname;

	@Column(name = "cbrief", length = 500, nullable = true)
	private String cbrief;

	@OneToOne
	@JoinColumn(name = "id")
	private User user;

	@Column(name = "ctime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ctime = new Date();

	@Column(name = "cpic", length = 30, nullable = true)
	private String cpic;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCbrief() {
		return cbrief;
	}

	public void setCbrief(String cbrief) {
		this.cbrief = cbrief;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getCpic() {
		return cpic;
	}

	public void setCpic(String cpic) {
		this.cpic = cpic;
	}

}
