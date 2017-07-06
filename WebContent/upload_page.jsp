<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>uploadPage</title>
</head>
<body>
<input type="button" value="<---" onclick="location.href='home_page.jsp'"><br>
	<h1>上传备份</h1>
	<form action="upload.action" method="POST" enctype="multipart/form-data">
		题目：<input type="text" name="title"><br>
		文件：<input type="file"  name="myFile"><br>
		<input type="submit" value="上传">
		<br>
	</form>
</body>
</html>