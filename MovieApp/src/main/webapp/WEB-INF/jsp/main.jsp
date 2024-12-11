<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" import="model.Comment" import="java.util.List" %>
<%
User loginUser = (User)session.getAttribute("loginUser");
List<Comment> commentList = (List<Comment>)application.getAttribute("commentList");
String emg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>メイン</h1>
<p>
	<%= loginUser.getName() %>さん、ログイン中
	<a href="Logout">ログアウト</a>
</p>
<a href="Main">更新</a>
<p>
<form action="Main" method="post">
	タイトル:<input type="text" name="title" required>
	<br>
	コメント:<textarea name="text"></textarea>
	<br>
	<input type="submit" value="投稿">
</form>
<%if(emg!= null){%>
	<p><%=emg %></p>
<%} %>
</p>
<table border ="1">
	<tr>
		<th>名前</th>
		<th>タイトル</th>
		<th>一言</th>
	</tr>
	<% for(Comment comment : commentList){%>
		<tr>
			<td><%=comment.getUserName() %></td>
			<td><%=comment.getTitle() %></td>
			<td><%=comment.getText() %></td>
		</tr>
	<%} %>
</table>
</body>
</html>
