<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="java.util.ArrayList" %>

<%@page import="bean.*" %>
<%@page import="dao.*" %>

<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/userList.css">

<%
request.setCharacterEncoding("UTF-8");
ArrayList<Item> itemList = (ArrayList<Item>)request.getAttribute("itemList");
%>

<html>
	<head>
	<title>Vicon</title>
	</head>
	<body>

		<%@include file="/common/header.jsp" %>

		<div class="container">
			<h2>商品ごとの売上げ一覧</h2>
			<div class="userlist_flex">
				<form action="<%= request.getContextPath() %>/Serch">
					ユーザー名：<input type=text size="10" name="userName">
					カテゴリー：<input type=text size="10" name="category">
					購入日時：<input type=text size="10" name="boughtTime">
					購入者：<input type=text size="10" name="buyer">
					<input type="submit"name="search" value="検索">
				</form>
				<form action="<%= request.getContextPath() %>/Serch">
					<input type="submit" name="searchall" value="全件表示">
				</form>
			</div>

			<table class="userlist-table">
				<tr>
					<th>ユーザー名</th>
					<th>商品名</th>
					<th>カテゴリー</th>
					<th>金額</th>
					<th>購入日時</th>
					<th>購入者</th>
					<th>出品日時</th>
				</tr>

				<!-- 繰り返し処理 -->
				<%
				UserDAO userDao = new UserDAO();
				IdToNameDAO idToNameDao = new IdToNameDAO();
				for(int i = 0; i < itemList.size(); i++){
					Item item = itemList.get(i);
					User sellerUser = userDao.searchByUserId(item.getSellerId());
					User buyerUser = userDao.searchByUserId(item.getBuyerId());
					String category = idToNameDao.categoryIdToName(item.getCategoryId());
				%>
				<tr>
					<td><%= buyerUser.getUserName() %></td>
					<td><%= item.getItemName() %></td>
					<td><%= category %></td>
					<td><%= item.getPrice() %></td>
					<td><%= item.getBoughtTime() %></td>
					<td><%= sellerUser.getUserName() %></td>
					<td><%= item.getInsertedTime() %></td>
				</tr>

				<%
				}
				%>
			</table>
		</div>
	</body>
</html>
