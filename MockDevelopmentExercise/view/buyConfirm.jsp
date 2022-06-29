<%@page contentType= "text/html;charset=UTF-8" %>
<%@page import="bean.Item, util.MyFormat"%>

<%
Item item = (Item)request.getAttribute("item");
MyFormat moneyFormat = new MyFormat();
%>
<html>
	<head>
		<title>購入確認</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/menu.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/userInfo.css">
	</head>
	<body>
		<%@include file="/common/header.jsp" %>
		<div class="container">
			<%
				if(item != null){
			%>
			<table class="userInfo-table">
			<tr>
				<th>商品名</th>
				<td><%= item.getItemName() %></td>
			</tr>
			<tr>
				<th>値段</th>
				<td><%= moneyFormat.moneyFormat(item.getPrice()) %></td>
			</tr>
			<tr>
				<th>購入日時</th>
				<td><%= item.getBoughtTime() %></td>
			</tr>
			</table>
			<%
				}
			%>
			<br>
			<a href="<%= request.getContextPath() %>/Index">トップページ</a>
		</div>
	</body>
</html>
