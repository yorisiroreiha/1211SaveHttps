<%@page import="model.Collections"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Collections> list = (List<Collections>)request.getAttribute("Notitle");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (list != null && !list.isEmpty()) { %>
<div class="row">
    <% for (int i = 0; i < list.size(); i++) { %>
    <div class="col-md-4">
        <div class="card border border-primary" style="width: 18rem;margin-top:10px">
            <iframe src="<%= list.get(i).getBody() %>" 
                frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                allowfullscreen></iframe>
            <div class="card-body">
                <h5 class="card-title"><%= list.get(i).getTitle() %></h5>
                <p class="card-text">
                    <%= list.get(i).getComment() %>
                    <br>
                    <a href="Update?id=<%= list.get(i).getId() %>">更新</a>
                    <a href="Delete?id=<%= list.get(i).getId() %>">削除</a> <!-- 削除のリンク修正 -->
                </p>
            </div>
        </div>
    </div>
    <% } %>
</div>
<% } %>
</body>
</html>
