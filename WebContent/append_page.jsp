<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>addendPage</title>
</head>
<body>
<input type="button" value="<---" onclick="location.href='home_page.jsp'"><br>
	<h1>添加单词</h1>
	<font color="red">${englishError}</font><br>
	<form action="append.action" >
		单词<input name="word.english" type="text"><br>
		中文<input name="word.chinese" type="text"><br>
		<input type="submit" value="提交">
		<input type="button" value="首页" onclick="location.href='home_page.jsp'"><br>
		<br>

	</form>
</body>
</html>