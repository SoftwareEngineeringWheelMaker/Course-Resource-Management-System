package com.course.action;

import com.course.domain.Msg;
import com.course.domain.SendMsg;
import com.course.domain.User;
import com.course.service.MsgService;
import com.course.service.SendMsgService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MsgAction extends ActionSupport {
	private MsgService msgService;
	private SendMsgService sendMsgService;
	private Msg msg;
	private SendMsg sendMsg;
	private User user;

	private static final int NORMAL = 0;
	private static final int DELETE = 1;
	private static final int UNREAD = 0;
	private static final int READED = 1;

	public MsgService getMsgService() {
		return msgService;
	}

	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}

	public SendMsgService getSendMsgService() {
		return sendMsgService;
	}

	public void setSendMsgService(SendMsgService sendMsgService) {
		this.sendMsgService = sendMsgService;
	}

	public Msg getMsg() {
		return msg;
	}

	public void setMsg(Msg msg) {
		this.msg = msg;
	}

	public SendMsg getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(SendMsg sendMsg) {
		this.sendMsg = sendMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String add() throws Exception {
		// System.out.println(msg.getMtitle());
		// System.out.println(msg.getMcontent());
		// msg.setUser(user);
		System.out.println("userid" + user.getId());
		msgService.saveMsg(msg);
		System.out.println("mid=" + msg.getMid());
		String message = "发布成功！";
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("message", message);
		System.out.println(message);
		return "success";
	}

	// 一对一发送消息
	public String sendsingle() throws Exception {
		// 站内消息表写入
		msgService.saveMsg(msg);
		sendMsg.setMsgid(msg);
		sendMsg.setSenderstatus(NORMAL);
		sendMsg.setReceiverstatus(NORMAL);
		sendMsg.setReadstatus(UNREAD);
		// 发送消息表写入
		sendMsgService.saveSendMsg(sendMsg);

		String message = "发布成功！";
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("message", message);
		System.out.println(message);
		return "success";
	}

	// 一对多（班级）发送消息
	public String sendmultiple() throws Exception {

		return "success";
	}
}
