<%@page contentType="text/html;charset=UTF-8"%>
<%@page
	import="java.util.ArrayList,bean.User,bean.Item,dao.ItemDAO,util.MyFormat"%>

<%
	User user = (User) session.getAttribute("user");
	ItemDAO itemDaoObj = new ItemDAO();
	MyFormat moneyFormat = new MyFormat();
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/menu.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/recommendation.css">
<title>Viconマイぺージ</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="container">
		<h1>マイページ</h1>
		<div class="menu">
			<h3 class="user-name"><%=user.getUserName()%>さん
			</h3>

			<div class="container">
				<%
					if (user.getAuthority() == 1) {
				%>
				<p class="favorite-list">
					<a href="<%=request.getContextPath()%>/Favorite?cmd=list">お気に入り一覧</a>
				</p>
				<p class="updatePayment-Shipment">
					<a href="<%=request.getContextPath()%>/UpdatePayAndShip">入金状況／発送確認</a>
				</p>
				<p class="userInfo">
					<a href="<%=request.getContextPath()%>/UserInfo">ユーザー情報</a>
				</p>
				<h4>出品商品一覧</h4>

				<div class="item-list">
					<!-- 出品している商品を一覧で表示 -->
					<%
						ArrayList<Item> itemList = (ArrayList<Item>) request.getAttribute("itemList");
							int count = 0; //真似して入れてみました
							for (int i = 0; i < itemList.size(); i++) {
								count++;
					%>
					<div class="recommendation-item" id="<%=count%>">
						<a
							href="<%=request.getContextPath()%>/ItemDetail?itemId=<%=itemList.get(i).getItemId()%>">
							<div class="picture">
								<img
									src="<%=request.getContextPath()%>/common/image/<%=itemList.get(i).getImage1()%>"
									alt="NO IMAGE">
								<p class="price"><%=moneyFormat.moneyFormat(itemList.get(i).getPrice())%></p>
							</div> <span class="item-name"><%=itemList.get(i).getItemName()%></span>
						</a>
					</div>
					<%
						}
					%>
				</div>
				<%
					} else if (user.getAuthority() == 2) {
				%>
				<p class="">
					<a href="<%=request.getContextPath()%>/ItemList">出品一覧</a>
				</p>
				<p class="">
					<a href="<%=request.getContextPath()%>/SalesList?cmd=sales">商品ごとの売り上げ一覧</a>
				</p>
				<p class="">
					<a href="<%=request.getContextPath()%>/UserList">ユーザ一覧</a>
				</p>
				<p class="">
					<a href="<%=request.getContextPath()%>/SellerList">出品者一覧</a>
				</p>
				<%
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>
