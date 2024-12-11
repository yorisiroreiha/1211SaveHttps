<%@page import="model.Data"%>
<%@page import="java.util.*" %>
<%@ include file="Head.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Data> list = (List<Data>)request.getAttribute("dataList");
	String[] status  = {"STR","CON","DEX","AGI","INT","SEC","MET","LUC"};
%>
<!DOCTYPE html>
<html>
<body>
	<div class="big1">
		<input id="requestId" type="number" max="${dataList.size()}" min="1" placeholder="数字を入れてね">
		<button id="button">検索</button>
	</div>
	<div class="big2">
		<table id="pickup"></table>
	</div>
	<div class="big4">
	<table id="insertData">
	<form action="" method="post">
		<tr class="top">
			<th>id</th>
			<th>Name</th>
    		<th>Pass</th>
    	</tr>
    	<tr>
    		<td><input type="number" min="${dataList.size()+1}" placeholder="数字入れてね" name="id" id="minimam"></td>
			<td><input type="text" min="${dataList.size()+1}" name="name"></td>
			<td><input type="text" min="${dataList.size()+1}" name="pass"></td>
    	</tr>
    	</table>
    	<table id="insertData">
    	<tr>
    		<th>Strength</th>
    		<th>Constitution</th>
    		<th>Dexterity</th>
    		<th>Agility</th>
    		<th>Intelligence</th>
    		<th>Sensing</th>
    		<th>Mentality</th>
    		<th>Luck</th>
		</tr>
		<tr>
			<%for(int i = 0 ; i < 8 ; i++ ){ %>
				<td><input type="number" min="1" placeholder="<%=status[i]%>" name="<%=status[i]%>"></td>
			<%} %>
		</tr>
		</table>
		<button type="submit" class="insert">登録</button>
	</form>
	</div>
	<div class="hide">
		<div class="box">
			<p>test</p>
		</div>
	</div>
	<div class="big3">
	<table id="allList">
		<tr class="top">
			<th>id</th>
			<th>Name</th>
        	<th>Pass</th>
       		<th>Strength</th>
        	<th>Constitution</th>
        	<th>Dexterity</th>
        	<th>Agility</th>
        	<th>Intelligence</th>
        	<th>Sensing</th>
        	<th>Mentality</th>
        	<th>Luck</th>
		</tr>
		<% for(int i = 0; i < list.size(); i++) { %>
			<tr class="childrendata">
				<td class="target1"><%=list.get(i).getId() %></td>
				<td class="target2"><%=list.get(i).getName() %></td>
        		<td class="target3"><%=list.get(i).getPass() %></td>
       			<td class="target4"><%=list.get(i).getSTR() %></td>
        		<td class="target5"><%=list.get(i).getCON() %></td>
        		<td class="target6"><%=list.get(i).getDEX() %></td>
        		<td class="target7"><%=list.get(i).getAGI() %></td>
        		<td class="target8"><%=list.get(i).getINT() %></td>
        		<td class="target9"><%=list.get(i).getSEC() %></td>
        		<td class="target10"><%=list.get(i).getMET() %></td>
        		<td class="target11"><%=list.get(i).getLUC() %></td>
        	</tr>
		<% } %>
	</table>
	</div>
	<script src="js/main.js></script>
</body>
</html>
