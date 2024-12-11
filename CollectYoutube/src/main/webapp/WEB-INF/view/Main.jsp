<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.*" %>
<%
UserNeed und = (UserNeed)request.getAttribute("User");
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<title>動画保存庫</title>
</head>
<body style="background-color: aqua;">
<%@ include file="Header.jsp" %>
<p><a href="Insert">新規データを追加</a></p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<a href="Main">検索状態を解除する</a>
<div class="container-fluid">
<form action="Main" method="get" class="row">
	<div class="mb-3 col-4">
		<label for="exampleFormControlInput1" class="form-label">検索ワード</label>
		<input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="ひらがなでの登録をお願いしてるよ" required autofocus value="<%= und != null ? und.getTitle() : "" %>">
	</div>
	<div class="col-2">
		<label for="exampleFormControlInput1" class="form-label">検索基準</label>
    	<select name="choice" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
     	   <option value="0">で始まる</option>
     	   <option value="1">で終わる</option>
     	   <option value="2">を含む</option>
    	   <option value="3">と一致</option>
  	  </select>
    </div>
    <input type="submit" value="検索">
</form>
<p><%= msg != null ? msg : "" %></p>
<% if (und != null && und.getLimitList() != null && !und.getLimitList().isEmpty()) { %>
<div class="row">
    <% for (int i = 0; i < und.getLimitList().size(); i++) { %>
    <div class="col-md-4">
    <div class="card border border-primary" style="width: 18rem;" >
      <iframe  src="<%= und.getLimitList().get(i).getBody() %>" 
         frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
          allowfullscreen></iframe>
          <div class="card-body">
          <h5 class="card-title"><%= und.getLimitList().get(i).getTitle() %></h5>
          <p class="card-text">
          <%= und.getLimitList().get(i).getComment() %>
          <br>
          <a href="Update?id=<%=und.getLimitList().get(i).getId()  %>">更新</a>
          <a href="Update?id=<%=und.getLimitList().get(i).getId()  %>">削除</a>
          </p>
          </div>
</div>
</div>
<%} %>
</div>
<% }%>
<%if (und != null && und.getList() != null && !und.getList().isEmpty()){%>
	<%for( int i = 0 ; i < und.getList().size()/12+1 ; i++ ){ %>
		<a href="Main?title=<%=und.getTitle() %>&choice=<%=und.getChoice() %>&page=<%=i+1%>"><%=i+1 %></a>
	<%} %>
<%} %>
</div>
<%@ include file="Main2.jsp"%>
</body>
</html>
