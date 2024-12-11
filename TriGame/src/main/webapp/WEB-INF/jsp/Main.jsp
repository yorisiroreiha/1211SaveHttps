<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="stacker.CountAll" %>
<%@ page import="stacker.Messege" %>
<%
CountAll ca = (CountAll)session.getAttribute("ca");
Messege mes = (Messege)session.getAttribute("mes");
%>
<%
if (ca == null) {
    session.setAttribute("ca", ca); // セッションに保存
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TriGame" method="post">
	O<input type="radio" value="グー" name="hand">
	V<input type="radio" value="チョキ" name="hand">
	X<input type="radio" value="パー" name="hand">
	<br>
	<input type="submit" value="勝負">
</form>
<h3>相手の手<%=mes.getEnemyHand() %></h3>
<h3>貴方の手<%=mes.getPlayerHand() %></h3>
<h2>結果<%=mes.getMessege() %></h2>
勝利<%=ca.getWin()%><br>
引き分け<%=ca.getDrow() %><br>
負け<%=ca.getLose() %>
<a href="EndGame">勝敗をリセットする</a>
</body>
</html>