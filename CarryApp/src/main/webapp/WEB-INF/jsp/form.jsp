<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carry App</title>
</head>
<body>
<h1>今日のカレー</h1>
<form action="CurryMain" method="post">
	<input type="radio" name="main" value="ビーフ"> ビーフ<br>
	<input type="radio" name="main" value="チキン">チキン<br>
	<input type="radio" name="main" value="ポーク">ポーク<br>
	<p>トッピングの種類は何種類？</p>
	<input type="number" name="times" max="18" min="0">
	<br>
	<input type="submit" value="送信">
</form>
</body>
</html>