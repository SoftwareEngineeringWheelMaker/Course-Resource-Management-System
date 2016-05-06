<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传课程资源</title>
<script type="text/javascript">
	function addComponet() {
		var uploadHTML = document
				.createElement("<input type='file' name='upload' />");
		document.getElementById("files").appendChild(uploadHTML);
		uploadHTML = document.createElement("<br>");
		document.getElementById("files").appendChild(uploadHTML);
	}
</script>
</head>
<body>
	<s:fielderror />
	<br>
	<input type="button" onclick="addComponet();" value="继续添加" />
	<s:form action="resource_upload" method="post" namespace="/"
		enctype="multipart/form-data">
		<s:textfield name="user.id" label="发布资源用户ID"/>
		<!-- 假设课程id为1 -->
		<s:hidden name="course.cid" value="1" />
		<span id="files"> <input type="file" name="upload" /><br></span>
		<input type="submit" value="上传" />
	</s:form>
</body>
</html>