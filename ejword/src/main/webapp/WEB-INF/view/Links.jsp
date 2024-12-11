<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = und.getTitle();
	int Choice = und.getChoice();
	int nowPage = und.getPage();
	String keyURL = "Main?title="+title+"&choice="+Choice+"&page=";
	int move = 0 ;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if( und.getList().size() > und.getLimit() ){ %>
<div class="mt-10  justify-content-center">
<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#"></a></li>
    <li class="page-item"><a class="page-link" href="<%=keyURL %><%=nowPage-1%>"><%=nowPage-1 %></a></li>
    <li class="page-item"><a class="page-link" href="<%=keyURL %><%=nowPage%>"><%=nowPage %></a></li>
    <li class="page-item"><a class="page-link" href="<%=keyURL %><%=nowPage+1%>"><%=nowPage+1 %></a></li>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav>
</div>
<%} %>
</body>
</html>