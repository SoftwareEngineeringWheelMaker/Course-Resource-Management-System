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

@Table(name = "Homework")
@Entity
public class Homework implements Serializable {
	/**
	 * hid htitle hcontent hdate hdeadline id
	 */
	@Id
	@Column(name = "hid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hid;

	@Column(name = "htitle", length = 30, nullable = false)
	private String htitle;

	@Column(name = "hcontent", length = 1000, nullable = true)
	private String hcontent;

	@Column(name = "htime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date htime = new Date();

	@Column(name = "hdeadline", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date hdeadline;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private User user;

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getHtitle() {
		return htitle;
	}

	public void setHtitle(String htitle) {
		this.htitle = htitle;
	}

	public String getHcontent() {
		return hcontent;
	}

	public void setHcontent(String hcontent) {
		this.hcontent = hcontent;
	}

	public Date getHtime() {
		return htime;
	}

	public void setHtime(Date htime) {
		this.htime = htime;
	}

	public Date getHdeadline() {
		return hdeadline;
	}

	public void setHdeadline(Date hdeadline) {
		this.hdeadline = hdeadline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
