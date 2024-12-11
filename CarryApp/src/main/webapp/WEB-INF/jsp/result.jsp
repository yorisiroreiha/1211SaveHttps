<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Carry" %>
<%
	Carry carry1 = (Carry)request.getAttribute("carrys"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carry App</title>
</head>
<body>
<p>
今日のカレーは「<%=carry1.getMenu() %><%=carry1.getMain() %>カレー」に決まりました！
</p>
<a href="CurryMain">戻る</a>
</body>
</html>