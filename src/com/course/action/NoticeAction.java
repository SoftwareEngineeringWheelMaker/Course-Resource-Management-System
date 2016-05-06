package com.course.action;

import com.course.domain.Notice;
import com.course.domain.User;
import com.course.service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NoticeAction extends ActionSupport {
	private NoticeService noticeService;
	private Notice notice;
	private User user;

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String add(){
		notice.setUser(user);
		noticeService.saveNotice(notice);
		String message = "发布成功！";
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("message", message);
		return "success";
	}
}
