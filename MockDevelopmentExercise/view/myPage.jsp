<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<%@page import="bean.Item"%>
<%@page import="dao.ItemDAO"%>
<%@page import="java.util.ArrayList"%>

<%
	User user = new User();
	//User user = (User)session.getAttribute("user");
	ItemDAO itemDaoObj = new ItemDAO();
%>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>css/menu.css">
<link rel="recommendation" href="<%=request.getContextPath()%>css/recommendation.css">
	href="<%=request.getContextPath()%>css/recommendation.css">
<title>神田雑貨店フリマ マイページ</title>
</head>
<body>
	<!--  ヘッダーをインクルードする -->
	<header>
		<nav class="nav-normal">
			<ul>
				<li class="logo">神田雑貨店</li>
				<li><a href="#">HOME</a></li>
				<li><a href="#">商品一覧</a></li>
				<li><input type="text" name="" id="" class="search"
					placeholder="なにをお探しですか？"><input type="button" value="🔍"
					class="search"></li>
				<li><div class="spacer"></div></li>
				<li><a href="#">ログアウト</a></li>
			</ul>
		</nav>
	</header>
	<div class="container">

		<h1>マイページ</h1>
		<div class="menu">
			<h3 class="user-name"><%=user.getUserName()%>さん
			</h3>
			<!-- 出品している商品を一覧で表示 -->
			<div class="container">

				<p class="favorite-list">
					<a href="/favorite?cmd=list">お気に入り一覧</a>
				</p>
				<!-- listで一覧、addで追加、deleteで削除 -->
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
								if(itemList.get(i).getBuyerId() != 0){
					%>
					<div class="recommendation-item" id="item1">
						<a href="#">
							<div class="picture">
								<img
									src="<%=request.getContextPath()%><%=itemList.get(i).getImage1()%>"
									alt="">
								<p class="price"><%=itemList.get(i).getPrice()%></p>
							</div> <span class="item-name"><%=itemList.get(i).getItemName()%></span>
						</a>
					</div>
					<%
						}
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
