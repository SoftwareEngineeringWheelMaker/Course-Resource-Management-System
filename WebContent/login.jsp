<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<s:form action="login" method="post">
	<s:textfield name="user.name" label="姓名" />
	<s:password name="user.password" label="密码" />
	<s:submit value="登录" />
</s:form>
</head>
<body>
</body>
</html>