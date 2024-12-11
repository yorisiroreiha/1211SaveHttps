<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%
Todo todo = (Todo)request.getAttribute("change");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Update" method="post">
	title:<input type="text" name="title" value="<%=todo.getTitle() %>">
	imp:
	<select name="importance">
		<%for( int i = 0 ; i  < 5 ; i++ ){ %>
			<option value=<%=i+1 %>>
			<%String s = "★"; %>
				<%for( int j = 0 ; j < i+1 ; j++ ){%>
				<%=s %>
				<%} %>
			</option>
		<%} %>
	</select>
	<input type="hidden" name="id" value="<%=todo.getId() %>">
	<br>
	<input type="submit" value="更新">
</form>
</body>
</html>