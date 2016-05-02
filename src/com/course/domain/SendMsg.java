package com.course.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "SendMsg")
@Entity
public class SendMsg {
	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;

	@ManyToOne()
	@JoinColumn(name = "senderid", nullable = false)
	private User sender;

	@ManyToOne()
	@JoinColumn(name = "receiverid", nullable = false)
	private User receiver;

	@OneToOne()
	@JoinColumn(name = "msgid", nullable = false)
	private Msg msgid;

	@Column(name = "senderstatus", nullable = false)
	private Integer senderstatus;

	@Column(name = "receiverstatus", nullable = false)
	private Integer receiverstatus;

	@Column(name = "readstatus", nullable = false)
	private Integer readstatus;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Msg getMsgid() {
		return msgid;
	}

	public void setMsgid(Msg msgid) {
		this.msgid = msgid;
	}

	public Integer getSenderstatus() {
		return senderstatus;
	}

	public void setSenderstatus(Integer senderstatus) {
		this.senderstatus = senderstatus;
	}

	public Integer getReceiverstatus() {
		return receiverstatus;
	}

	public void setReceiverstatus(Integer receiverstatus) {
		this.receiverstatus = receiverstatus;
	}

	public Integer getReadstatus() {
		return readstatus;
	}

	public void setReadstatus(Integer readstatus) {
		this.readstatus = readstatus;
	}

}
