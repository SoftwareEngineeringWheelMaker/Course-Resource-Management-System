<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加公告</title>
</head>
<body>
	<s:form action="notice_add" method="post" namespace="/">
		<s:textfield name="notice.ntitle" label="公告标题" />
		<s:textarea name="notice.ncontent" label="公告内容" />
		<s:textfield name="user.id" label="发布公告用户ID" />
		<s:submit value="发布" />
	</s:form>
</body>
</html>