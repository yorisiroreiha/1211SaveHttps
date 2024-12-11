<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="ex.Fruit" %>
 <%
 	Fruit fruit = new Fruit("イチゴ",700);
 	Fruit fruit2 = (Fruit)request.getAttribute("fruit");
 	Fruit fruit3 = (Fruit)session.getAttribute("fruit2");
 %>
 <%
 session.removeAttribute("fruit2"); 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<P><%=fruit.getName() %>の値段は<%=fruit.getPrice() %>円です</P>
<%System.out.println("cont"); %>
<P><%=fruit2.getName() %>の値段は<%=fruit2.getPrice() %>円です</P>
<P><%=fruit3.getName() %>の値段は<%=fruit3.getPrice() %>円です</P>
<a href="/Example/FirstFruit.html">戻る</a>
<a href="/Example/FirstFruit.html">削除して戻る</a>
</body>
</html>