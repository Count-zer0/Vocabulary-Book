<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>wordPage</title>
</head>
<body>
<input type="button" value="<---" onclick="location.href='home_page.jsp'"><br>
	<h1>单词：<font color="red">${Word.english}</font></h1>
	<h1>意思：<font color="red">${Word.chinese}</font></h1>
	<input type="button" value="全部单词" onclick="location.href='wordList_page.jsp'">
</body>
</html>