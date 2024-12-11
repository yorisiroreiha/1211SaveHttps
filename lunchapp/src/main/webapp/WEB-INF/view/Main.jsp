<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*" %>
<%
List<Lunch> list = (List<Lunch>)request.getAttribute("list");
String msg = (String)session.getAttribute("msg");
if( msg != null ){
	session.removeAttribute("msg");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lunch APP</title>
</head>
<body>
<h1>Lunch List</h1>
<p><a href="Insert">新規データを追加</a></p>
<%if( list != null && !list.isEmpty() ){%>
	<table border="1"> 
		<tr>
			<th>Shop</th>
			<th>Menu</th>
			<th>操作</th>
		</tr>
		<%for( Lunch lunch : list ){ %>
			<tr>
				<td><%=lunch.getShop() %></td>
				<td><%=lunch.getMenu() %></td>
				<td>
					<a href="Update?id=<%=lunch.getId()  %>">更新</a>
					<a href="Delete?id=<%=lunch.getId() %>" onclick="return　confirm('[<%=lunch.getShop()%>]:[<%=lunch.getMenu()%>]を削除してよろしいですか？')">削除</a>
				</td>
			</tr>
		<%} %>
	</table>
<%}else{ %>
	<p>データがありません</p>
<%} %>
<P><%if( msg != null){ %><%=msg%><%} %></P>
</body>
</html>