<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.*" %>
 <%
 Collections collection = (Collections)request.getAttribute("collection");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動画保存庫</title>
</head>
<body>
<p>内容を修正して更新ボタンを押してください</p>
<form action="Update" method="post">
title:<input type="text" name="title" value="<%=collection.getTitle() %>"><br>
URL:<input type="text" name="body" value="<%=collection.getBody() %>"><br>
Comment:<input type="text" name="comment" value="<%=collection.getComment() %>"><br>
<input type="number" name="id" value="<%=collection.getId() %>" ><br>
<button type="submit">更新</button>
</form>
</body>
</html>