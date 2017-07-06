<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>downloadPage</title>
</head>
<body>
<input type="button" value="<---" onclick="location.href='home_page.jsp'"><br>
	<h1>下载备份</h1>
	<form action="download.action" >
		文件：<input type="file"  name="myFile"><br>
		<input type="submit" value="下载">
		<br>
	</form>
</body>
</html>