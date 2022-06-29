<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="java.util.ArrayList" %>

<%@page import="bean.*" %>
<%@page import="dao.*" %>

<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/menu.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/userList.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/salesList.css">

<%
request.setCharacterEncoding("UTF-8");
ArrayList<Item> itemList = (ArrayList<Item>)request.getAttribute("itemList");
%>

<html>
	<head>
	<title>Vicon 売上げ</title>
	</head>
	<body>

		<%@include file="/common/header.jsp" %>

		<div class="container">
			<h2>商品ごとの売上げ一覧</h2>
			<div class="userlist_flex">
				<form action="<%= request.getContextPath() %>/SalesList" method="get">
					出品者名：<input type="text" name="sellerName">
					カテゴリー：<select name="category">
						<option value=0 selected>カテゴリー</option>
						<option value=1>服</option>
						<option value=2>本・音楽・ゲーム</option>
						<option value=3>家具・インテリア</option>
						<option value=4>食器</option>
						<option value=5>家電</option>
						<option value=6>おもちゃ・ホビー・グッズ</option>
						<option value=7>化粧品・香水</option>
						<option value=8>その他</option>
					</select>
					購入者名：<input type="text" name="buyerName">
					<input type="hidden" name="cmd" value="searchSales">
					<input type="submit" name="search" value="検索">
				</form>
				<form action="<%= request.getContextPath() %>/SalesList" method="get">
					<input type="submit" name="searchall" value="全件表示">
				</form>
			</div>

			<table class="saleslist-table">
				<tr>
					<th>出品者名</th>
					<th>商品名</th>
					<th>カテゴリー</th>
					<th>金額</th>
					<th>購入日時</th>
					<th>購入者</th>
					<th>出品日時</th>
				</tr>

				<!-- 繰り返し処理 -->
				<%
				if(itemList != null){
					UserDAO userDao = new UserDAO();
					IdToNameDAO idToNameDao = new IdToNameDAO();
					for(int i = 0; i < itemList.size(); i++){
						Item item = itemList.get(i);
						//出品者、購入者、カテゴリをidから名前に変換する
						User sellerUser = userDao.searchByUserId(item.getSellerId());
						User buyerUser = userDao.searchByUserId(item.getBuyerId());
						String category = idToNameDao.categoryIdToName(item.getCategoryId());
				%>
				<tr>
					<td><%= sellerUser.getUserName() %></td>
					<td><%= item.getItemName() %></td>
					<td><%= category %></td>
					<td><%= item.getPrice() %></td>
					<td><%= item.getBoughtTime() %></td>
					<td><%= buyerUser.getUserName() %></td>
					<td><%= item.getInsertedTime() %></td>
				</tr>

				<%
					}
				}
				%>
			</table>
		</div>
	</body>
</html>
