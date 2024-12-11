<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Human" %>
    <%
    /*リクエストスコープから*/
    	Human human = (Human)request.getAttribute("human");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>フォワードの実験</h1>
<p>フォワードされたページです</p>
<p>名前:<%=human.getName() %>,年齢:<%=human.getAge() %></p>
</body>
</html>