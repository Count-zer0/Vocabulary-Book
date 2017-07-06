<%@page import="java.sql.*"%>
<%@page import="Dao.WordDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>HomePage</title>

<style type="text/css">
div{
float:right;
margin:20 150px; /* 这个15px就是对于表格左右留出15像素的空间 */
}
</style>
</head>
<body>
<table  >
		<caption>Vocabulary BOOK</caption>
		
<%
	ResultSet eq=new WordDaoImpl().find("button");
	while(eq.next()){
		%>
		<tr>
		<td align="center"><%=eq.getString(2)%></td>
		</tr>
		<%}
		eq.close();
		%>
	</table>

 	<!--
	<input type="button" value="添加单词" onclick="location.href='append_page.jsp'"	><br>
	<input type="button" value="查询单词" onclick="location.href='findENbyCH_page.jsp'"><br>
	<input type="button" value="全部单词" onclick="location.href='wordList_page.jsp'"><br>
	<input type="button" value="上传备份" onclick="location.href='upload_page.jsp'"><br>
	<input type="button" value="下载备份" onclick="location.href='download.action'"><br>
	-->
</body>
</html>