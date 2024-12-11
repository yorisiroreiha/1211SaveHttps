<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.*" %>
 <%
 Lunch lunch = (Lunch)request.getAttribute("lunch");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lunch App</title>
</head>
<body>
<p>内容を修正して更新ボタンを押してください</p>
<form action="Update" method="post">
Shop:<input type="text" name="shop" value="<%=lunch.getShop() %>"><br>
Menu:<input type="text" name="menu" value="<%=lunch.getMenu() %>"><br>
<input type="hidden" name="id" value="<%=lunch.getId() %>" ><br>
<button type="submit">更新</button>
</form>
</body>
</html>