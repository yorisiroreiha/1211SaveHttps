<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動画保存庫</title>
</head>
<body>
<form action="Insert" method="post">
	Title:<input type="text" name="title" placeholder="ひらがなだけのがいいかも" autofocus required>
	<br>
	URL:<input type="text" name="body"  placeholder="URLを入れてね" required>
	<br>
	Comment:<textarea rows="3" cols="20"  name="comment">comment?</textarea>
	<br>
	<button type="submit">登録</button>
</form>
</body>
</html>