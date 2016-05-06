<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<sx:head />
<title>作业布置</title>
</head>
<body>
	<s:form action="homework_add" method="post" namespace="/">
		<s:textfield name="homework.htitle" label="作业标题" />
		<s:textfield name="homework.hcontent" label="作业内容" />
		<sx:datetimepicker name="homework.hdeadline" label="作业提交期限"
			displayFormat="yyyy-MM-dd" />
		<s:textfield name="user.id" label="布置作业教师ID" />
		<s:submit value="添加" />
	</s:form>
</body>
</html>