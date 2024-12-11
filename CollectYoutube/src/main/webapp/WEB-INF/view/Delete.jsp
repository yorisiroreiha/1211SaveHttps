<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card border border-primary" style="width: 18rem;">
	<iframe src="<c:out value='${collection.body}'/>" frameborder="1"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	<div class="card-body">
		<h4 class="card-title"><c:out value="${collection.title}"></c:out></h4>
		<p class="card-text"><c:out value="${collection.comment}"></c:out></p>
	</div>
</div>
<form action="Delete" method="post">
	pass:<input type="password" name="pass"  placeholder="中の人の誕生日">
	<input type="hidden"  name="title" value="${collection.title}">
	<input type="hidden"  name="body" value="${collection.body}">
	<input type="hidden"  name="comment" value="${collection.comment}">
	<input type="hidden"  name="id" value="${collection.id}">
	<button type="submit" value="削除">削除</button>
</form>
</body>
</html>