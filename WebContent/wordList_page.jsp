<%@page import="java.sql.*"%>
<%@page import="Dao.WordDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>wordListPage</title>
 <script language="javascript" type="text/javascript">
 function deleteFee(id) {
     var r = window.confirm("确定要删除此资费吗？");
     if(r) {    	
    		location.href = "delete.action?id="+id;
     }
 }
 function updateFee(id) {
     var r = window.confirm("确定要修改吗？");
     if(r) {    	
    		location.href = "update_page.jsp?word.id="+id;
     }
 }

 </script>      
</head>
<body>
	<table  border="1" width="350" bgcolor="#ffffff" align="left" cellspacing="1" cellpadding="1">
		<input type="button" value="<---" onclick="location.href='home_page.jsp'"><br>
		<caption>单词列表</caption>
		<tr>
		<td align="center">ID</td>
		<td align="center">单词</td>
		<td align="center">中文</td>
		<td align="center">修改</td>
		<td align="center">删除</td>

		</tr>
<%
	WordDaoImpl dao=new WordDaoImpl();
	ResultSet eq=dao.find("word");
	while(eq.next()){
		%>
		<tr>
		<td align="left"><%=eq.getInt("id")%></td>
		<td align="left"><%=eq.getString("english")%></td>
		<td align="left"><%=eq.getString("chinese")%></td>
		<td align="center"><input type="button" value="修改" onclick="updateFee(<%=eq.getInt("id")%>);"></td>
		<td align="center"><input type="button" value="删除" onclick="deleteFee(<%=eq.getInt("id")%>);"></td>
		</tr>
		<%}%>
	</table>
</body>
</html>