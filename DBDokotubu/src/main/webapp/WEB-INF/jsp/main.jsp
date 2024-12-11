<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" import="model.Mutter" import="java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
String emg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
	<%= loginUser.getName() %>さん、ログイン中
	<a href="Logout">ログアウト</a>
</p>
<a href="Main">更新</a>
<p>
<form action="Main" method="post">
	<input type="text" name="text">
	<input type="submit" value="つぶやく">
</form>
<%if(emg!= null){%>
	<p><%=emg %></p>
<%} %>
</p>
<% for(Mutter mutter : mutterList){%>
	<p>
		<%=mutter.getUserName() %>:<%=mutter.getText() %>
	</p>
<%} %>
</body>
</html>