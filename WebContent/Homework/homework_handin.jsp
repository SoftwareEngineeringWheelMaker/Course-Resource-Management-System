<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作业提交</title>
</head>
<body>
	<s:form action="homework_handin" method="post" namespace="/"
		enctype="multipart/form-data">
		<s:file type="file" name="upload" label="作业文件" />
		<s:textfield name="homework.hid" label="作业编号" />
		<s:textfield name="user.id" label="提交作业学生ID" />
		<s:submit value="提交" />
	</s:form>
</body>
</html>