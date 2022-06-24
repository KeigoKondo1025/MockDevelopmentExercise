<%@page contentType= "text/html;charset=UTF-8" %>
<%@page import="bean.Item"%>
<%
Item item = (Item)request.getAttribute("item");
%>
<html>
	<head>
		<title>購入確認</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/menu.css">
	</head>
	<body>
		<%@include file="../common/header.jsp" %>
		<div class="container">
			<%
				if(item != null){
			%>
			<p>商品名</p>
			<%= item.getItemName() %>
			<p>値段</p>
			<%= item.getPrice() %>
			<p>購入日時</p>
			<%= item.getBoughtTime() %>
			<%
				}
			%>
			<br>
			<a href="<%= request.getContextPath() %>/List">トップページ</a>
		</div>
	</body>
</html>