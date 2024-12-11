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
<title>検索ページ</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<div class="container-fluid">
<form action="Main" method="get" class="row">
	<div class="mb-3 col-4">
		<label for="exampleFormControlInput1" class="form-label">検索ワード</label>
		<input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="search" required autofocus value="<%= und != null ? und.getTitle() : "" %>">
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
<%if (und != null && und.getList() != null && !und.getList().isEmpty()){%>
	<%for( int i = 0 ; i < und.getList().size()/20+1 ; i++ ){ %>
		<a href="Main?title=<%=und.getTitle() %>&choice=<%=und.getChoice() %>&page=<%=i+1%>"><%=i+1 %></a>
	<%} %>
<%} %>
<% if (und != null && und.getLimitList() != null && !und.getLimitList().isEmpty()) { %>
<div class="row">
<table class="table table-bordered table-striped">
    <tr >
        <th class="col-2">検索内容</th>
        <th class="col-10">和訳</th>
    </tr>
    <% for (int i = 0; i < und.getLimitList().size(); i++) { %>
    <tr>
        <td><%= und.getLimitList().get(i).getTitle() %></td>
        <td><%= und.getLimitList().get(i).getBody() %></td>
    </tr>
    <% } %>
</table>
</div>
<%@ include file ="Links.jsp" %>
<% }%>
</div>
</body>
</html>
