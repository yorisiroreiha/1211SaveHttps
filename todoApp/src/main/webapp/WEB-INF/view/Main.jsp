<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*" %>
<%
List<Todo> list = (List<Todo>)request.getAttribute("list");
String msg = (String)session.getAttribute("msg");
if(msg != null){
	session.removeAttribute("msg");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo App</title>
</head>
<body>
<a href="Insert">新規作成</a>
<p><%if(msg!=null ){%><%= msg%><%} %></p>
<%if( list != null && !list.isEmpty()){ %>
	<ul>
	<%for( int i = 0 ; i < list.size() ; i++){ %>
		<li>
			<%=list.get(i).getTitle() %>&nbsp<%=list.get(i).getStar() %>
			<a href="Update?id=<%=list.get(i).getId() %>">更新</a>
			<a href="Delete?id=<%=list.get(i).getId() %>" onclick="return confirm('[<%=list.get(i).getTitle() %>]を削除してよろしいですか？')">削除</a>
		</li>
	<%} %>
	</ul>
<%}else{ %>
	<p>Todoリストはまだありません</p>
<%} %>
</body>
</html>