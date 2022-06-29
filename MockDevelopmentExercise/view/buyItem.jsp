<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="bean.*" %>
<%@page import="dao.*" %>
<%@page import="util.MyFormat" %>


<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/menu.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/itemDetail.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/buyitem.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/footer.css">

<%
request.setCharacterEncoding("UTF-8");
int itemId = Integer.parseInt(request.getParameter("itemId"));
ItemDAO itemDao = new ItemDAO();
Item item = itemDao.selectByItemId(itemId);
MyFormat myFormat = new MyFormat();
%>

<html>
	<head>
		<title>Vicon 購入</title>
	</head>
	<body>

		<%@include file="/common/header.jsp" %>

		<div class="container">
			<div class="item-detail">
				<div class="item-img-box">
					<img src="<%=request.getContextPath()%>/common/image/<%= item.getImage1() %>" alt="" srcset="" class="item-detail">
				</div>
				<div class="item-info buy-item-info">
					<form action="<%= request.getContextPath() %>/BuyItem" method="get">
						<p>商品名 <%= item.getItemName() %></p>
						<p>値段 <%= myFormat.moneyFormat(item.getPrice()) %></p>
						<p>商品詳細 <%= item.getSellerMessage() %></p>
						<input type="hidden" name="itemId" value=<%= item.getItemId() %>>
						
						<%
						if(item.getItemSituation() == 0){
						%>
						<br> <br> <input type="submit" value="購入する" class="buy-btn">
						<%
						}
						%>
					</form>
				</div>
			</div>
		</div>
		<%@include file="/common/footer.jsp" %>
	</body>
</html>
