<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 String path = (String) request.getAttribute("test");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>FlexboxLessonSP</title>
  <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link rel="stylesheet" href="CSS/main2.css">
</head>
<body>
    <header>
      <h1>Header</h1>
    </header>
    <nav>
      <ul>
        <li><a href="Home" class="<%=path.equals("/Home") ? "active" : ""%>">Home</a></li>
        <li><a href="Menu1" class="<%=path.equals("/Menu1") ? "active" : ""%>">Menu1</a></li>
        <li><a href="Menu2" class="<%=path.equals("/Menu2") ? "active" : ""%>">Menu2</a></li>
        <li><a href="Menu3" class="<%=path.equals("/Menu3") ? "active" : ""%>">Menu3</a></li>
        <li><a href="Menu4" class="<%=path.equals("/Menu4") ? "active" : ""%>">Menu4</a></li>
      </ul>
    </nav>
</body>
</html>
