<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增课程</title>
</head>
<body>
	<s:form action="course_add" method="post" namespace="/"
		enctype="multipart/form-data">
		<s:textfield name="course.cname" label="课程名称"/>
		<s:textarea name="course.cbrief" label="课程简介"/>
		<s:textfield name="user.id" label="创建课程教师ID"/>
		<s:file type="file" name="upload" label="课程图片"/>
		<s:submit value="添加"/>
	</s:form>
</body>
</html>