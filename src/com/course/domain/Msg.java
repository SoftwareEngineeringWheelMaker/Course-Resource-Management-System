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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "Msg")
@Entity
public class Msg implements Serializable {
	@Id
	@Column(name = "mid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mid;
	@Column(name = "mtitle", length = 30, nullable = false)
	private String mtitle;
	@Column(name = "mcontent", length = 1000, nullable = false)
	private String mcontent;
	@Column(name = "mtime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date mtime = new Date();
//	@OneToMany()
//	@JoinColumn(name = "id", nullable = false)
//	private User id;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
//	public User getId() {
//		return id;
//	}
//	public void setId(User id) {
//		this.id = id;
//	}

}
