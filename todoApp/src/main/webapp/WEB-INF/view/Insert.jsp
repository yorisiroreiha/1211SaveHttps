<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Insert" method="post">
	タイルと:<input type="text" name="title" value="null">
	重要度:<input type="number" name="importance" value="3" max="5" min="1">
	<input type="submit" value="追加">
</form>
</body>
</html>