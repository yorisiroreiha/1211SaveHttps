<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
 <%
	User registerUser = (User)session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<form action="RegisterUser" method="post">
	ログインID:<input type="text" name="id" value="<%=registerUser==null?"":registerUser.getId()%>">
	<br>
	パスワード:<input type="password" name="pass">
	<br>
	名前:<input type="text" name="name" value="<%=registerUser==null?"":registerUser.getName()%>">
	<br>
	<input type="submit" value="確認">
</form>
</body>
</html>