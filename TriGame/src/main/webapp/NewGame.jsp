<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stacker.CountAll" %>
<%
CountAll ca = (CountAll)session.getAttribute("ca");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TriGame" method="get">
	O<input type="radio" value="グー" name="hand">
	V<input type="radio" value="チョキ" name="hand">
	X<input type="radio" value="パー" name="hand">
	<br>
	<input type="submit" value="勝負">
</form>
</body>
</html>