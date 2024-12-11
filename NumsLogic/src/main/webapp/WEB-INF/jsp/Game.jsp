<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="number.Number" %>
 <%
	Number player = (Number)session.getAttribute("player");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>数字を当ててね</h2>
<form action="NUMBERSCHECK" method="post">
	<input type="number" min="1" max="99" name="playerNumber">
	<input type="submit" value="送信">
</form>
<% if(player==null){}else{
	for(int i = 0 ; i < player.getCount() ; i++ ){ %>
<table>
	<tr>
		<td><%=i+1 %></td>
		<td><%=player.getPlayerNumber(i) %></td>
		<td><%=player.getCheck(i)%></td>
	</tr>
</table>
<%} }%>
</body>
</html>