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

@Table(name = "Notice")
@Entity
public class Notice implements Serializable {

	@Id
	@Column(name = "nid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nid;

	@Column(name = "ntitle", length = 30, nullable = false)
	private String ntitle;

	@Column(name = "ncontent", length = 1000, nullable = false)
	private String ncontent;

	@Column(name = "ntime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ntime = new Date();

	@ManyToOne()
	@JoinColumn(name = "id", nullable = false)
	private User user;

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Date getNtime() {
		return ntime;
	}

	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
