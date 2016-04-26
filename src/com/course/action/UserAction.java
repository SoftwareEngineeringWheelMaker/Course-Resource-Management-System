package com.course.action;


import com.course.domain.User;
import com.course.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction  extends ActionSupport{
private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String regist() throws Exception {
		if(loginService.exist(user.getName())){
			loginService.saveUser(user);
			String message = "注册成功！！";
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("message", message);
			return "registsuccess";
		}
		else{
			String message = "注册失败！！";
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("message", message);
			System.out.println("注册失败");
			return "registfail";
		}
	}
	public String login() throws Exception{
		if(loginService.getUser(user.getName(), user.getPassword())){
			String message = "登陆成功！！";
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("message", message);
			return "loginsuccess";
		}
		else{
			String message = "登陆失败！！";
			ActionContext ac = ActionContext.getContext();
			ac.getSession().put("message", message);
			return "loginfail";
		}

	}
}
