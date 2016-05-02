<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送站内消息</title>
</head>
<body>
	<s:form action="msg_sendsingle" method="post" namespace="/">
		<s:textfield name="msg.mtitle" label="标题" />
		<s:textfield name="msg.mcontent" label="内容" />
		<s:textfield name="sendMsg.sender.id" label="发信人ID" />
		<s:textfield name="sendMsg.receiver.id" label="收信人ID" />
		<s:submit value="发布" />
	</s:form>
</body>
</html>