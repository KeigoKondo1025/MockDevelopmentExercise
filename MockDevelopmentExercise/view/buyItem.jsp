<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="bean.*" %>
<%@page import="dao.IdToNameDAO" %>


<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/itemDetail.css">
<link rel="stylesheet" href="css/buyitem.css">

<%
request.setCharacterEncoding("UTF-8");
Item item = (Item)request.getAttribute("item");
%>

<html>
	<head>
		<title>Vicon</title>
	</head>
	<body>

		<%@include file="/common/header.jsp" %>

		<div class="container">
			<div class="item-detail">
				<div class="item-img-box">
					<img src="<%= item.getImage1() %>" alt="" srcset="" class="item-detail">
				</div>
				<div class="item-info buy-item-info">
					<form action="<%= request.getContextPath() %>/BuyItem" method="POST">
						<p>商品名 <%= item.getItemName() %></p>
						<p>値段 <%= item.getPrice() %></p>
						<p>商品詳細 <%= item.getSellerMessage() %></p>
						<input type="hidden" name="itemId" value=<%= item.getItemId() %>>
						<br> <br> <input type="submit" value="購入する" class="buy-btn">
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
