<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User,bean.Item,dao.ItemDAO,util.MyFormat"%>

<%
	User user = (User)session.getAttribute("user");
	ItemDAO itemDaoObj = new ItemDAO();
	MyFormat moneyFormat = new MyFormat();
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/common/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/common/css/menu.css">
<link rel="recommendation"	href="<%=request.getContextPath()%>/common/css/recommendation.css">
<title>Viconマイぺージ</title>
</head>
<body>
<%@include file="/common/header.jsp"%>
	<div class="container">

		<h1>マイページ</h1>
		<div class="menu">
			<h3 class="user-name"><%=user.getUserName()%>さん
			</h3>
			<!-- 出品している商品を一覧で表示 -->
			<div class="container">

				<p class="favorite-list">
					<a href="/Favorite?cmd=list">お気に入り一覧</a>
				</p>
				<p class="updatePayment-Shipment">
					<a href="/updatePayAndShip.jsp">入金状況／発送確認</a>
				</p>
				<p class="userInfo">
					<a href="/userInfo.jsp">ユーザ情報</a>
				</p>
				<h4>出品商品一覧</h4>

				<div class="item-list">
					<%
						ArrayList<Item> itemList = (ArrayList<Item>) request.getAttribute("itemList");
						if (itemList != null) {
							for (int i = 0; i < itemList.size(); i++) {
					%>
					<div class="recommendation-item" id="item1">
						<a href="<%=request.getContextPath()%>/ItemDetail?itemId=<%=itemList.get(i).getItemId()%>">
							<div class="picture">
								<img
									src="<%=request.getContextPath()%><%=itemList.get(i).getImage1()%>"
									alt="NO IMAGE">
								<p class="price"><%=moneyFormat.moneyFormat(itemList.get(i).getPrice())%></p>
							</div> <span class="item-name"><%=itemList.get(i).getItemName()%></span>
						</a>
					</div>
					<%
							}
						} else {
					%>
					<br> <br>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
