<%@page import="java.sql.*"%>
<%@page import="Dao.WordDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>updatePage</title>
	<%
	String idStr=request.getParameter("word.id");
	int id=Integer.parseInt(idStr);
	try{
	ResultSet eq=new WordDaoImpl().find("word");
	while(eq.next()){
		if(eq.getInt("id")==id){
			request.setAttribute("ENGLISH",eq.getString("english"));
			request.setAttribute("CHINESE",eq.getString("chinese"));	
			request.setAttribute("ID",eq.getString("id"));	
		}
	}
	}catch(Exception e){
		e.printStackTrace();
	}
		%>
</head>
<body>
<input type="button" value="<---" onclick="location.href='home_page.jsp'"><br>
	<h1>修改单词</h1>
	<font color="red">${englishError}</font><br>
	<form action="update.action">
		<input type="text" name="word.id" value="${ID}" style="display:none">
		单词<input name="word.english" type="text" value="${ENGLISH}"><br>
		中文<input name="word.chinese" type="text" value="${CHINESE}"><br>
		<input type="submit" value="提交修改">
		<br>
	</form>
</body>
</html>