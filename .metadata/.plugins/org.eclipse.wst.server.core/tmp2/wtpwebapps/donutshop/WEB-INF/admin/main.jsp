<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
<style>
.container{
padding-top:20px;
padding-bottom:60px;
}
td>img{
width:200px;
}
input.form-control,
.alert{
	width:500px;
}
table.table{
	width:70%;
}
</style>
</head>
<body>
<div class="container">
<a href="/donutshop/Main" class="btn btn-outline-info btn-sm float-right">公開ページを見る</a>
<c:if test="${msg != null}">
	<div class="alert alert-success" role="alert">
	<c:out value="${msg}"/>
	</div>
</c:if>
<form class="mt-3" action="${pageContext.request.contextPath}/Admin" method="post" enctype="multipart/form-data">
	<div class="form-group">
	<label for="name">商品名</label>
	<input type="text" name="name" class="form-control" required autofocus>
	<br>
	</div>
	<div class="form-group">
	<label for="price">価格</label>
	<input type="number" name="price" class="form-control" required>
	<br>
	</div>
	<div class="form-group">
	<label for="imgname">商品画像</label>
	<input type="file" name="imgname" class="form-control" required>
	<br>
	</div>
	<button type="submit" class="btn btn-primary">登録</button> 
</form>
<c:if test="${not empty list}">
	<table class="table table-bordered mt-5">
		<c:forEach var="lists" items="${list}">
			<tr>
			<td><img src="/donutshop/upload/${lists.imgname}"</td>
			<td><c:out value="${lists.id}"></c:out></td>
			<td><c:out value="${lists.name}"></c:out></td>
			<td><c:out value="${lists.price}"></c:out></td>
			<td><a href="Admin/update?id=${lists.id}">更新</a></td>
			<td><a href="Admin/delete?id=${lists.id}" onclick="return confirm('削除してよろしいですか？')">削除</a></td>
			<tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>