<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*,java.util.*" %>
    <%
    List<Product> list = (List<Product>)application .getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Main" method="post">
	商品名:<input type="text" name="name" required autofocus>
	<br>
	価格:<input type="text" name="price">
	<br>
	<input type="submit" value="登録">
</form>
<table border="1">
	<tr>
		<th>製品名</th>
		<th>価格</th>
		<th>登録日</th>
	</tr>
	<% if( list != null && !list.isEmpty()){ %>
	<%System.out.println("true"); %>
		<%for(int i = 0 ; i < list.size() ; i++ ){%>
			<tr>
				<td><%=list.get(i).getName() %><%=1 %></td>
				<td><%=list.get(i).getPrice() %></td>
				<td><%=list.get(i).getDateTime() %></td>
			</tr>
		<%} %>
	<%} %>
</table>
</body>
</html>