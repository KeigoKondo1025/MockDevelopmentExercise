<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.User,bean.Item,dao.ItemDAO,util.MyFormat"%>

<%
	//User user = new User(); // テスト用結合後コメントアウト

	User user = (User)session.getAttribute("user"); // テスト時コメントアウト
	ItemDAO itemDaoObj = new ItemDAO();
	MyFormat moneyFormat = new MyFormat();
%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=request.getContextPath()%>/common/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/common/css/menu.css">
<link rel="recommendation"	href="<%=request.getContextPath()%>/common/css/recommendation.css">
<title>Vicon</title>
</head>
<body>
<%@include file="/common/header.jsp"%>

	<div class="container">
		<h1>お気に入り商品</h1>

		<!-- お気に入りテーブルから受け取った値を表示 -->
		<div class="recommendation">
		<%
					//ArrayList<Item> favoriteList = new ArrayList<Item>();// テスト用結合後コメントアウト
					//favoriteList = itemDaoObj.select("1003", "", "", ""); // テスト用結合後コメントアウト

					ArrayList<Item> favoriteList = (ArrayList<Item>) request.getAttribute("favoriteList"); // テスト時コメントアウト
					if (favoriteList != null) {
					for (int i = 0; i <favoriteList.size(); i++) {
			%>
			<div class="recommendation-item" id="item1">
				<a href="<%=request.getContextPath()%>/itemDetail"">
					<div class="picture">
						<img src="<%=request.getContextPath()%><%=favoriteList.get(i).getImage1()%>" alt="NO IMAGE">
						<p class="price">￥1,000</p>
					</div> <span class="item-name">商品1</span>

					<!-- 削除ボタンつけます！ -->
				</a>
			</div>

			<div class="recommendation-item" id="item1">
				<a href="#">
					<div class="picture">
						<img src="img/sample.png" alt="">
						<p class="price">￥1,000</p>
					</div> <span class="item-name">商品2</span>
				</a>
			</div>

			<div class="recommendation-item" id="item1">
				<a href="#">
					<div class="picture">
						<img src="img/sample.png" alt="">
						<p class="price">￥1,000</p>
					</div> <span class="item-name">商品3</span>
				</a>
			</div>

			<div class="recommendation-item" id="item1">
				<a href="#">
					<div class="picture">
						<img src="img/sample.png" alt="">
						<p class="price">￥1,000</p>
					</div> <span class="item-name">商品4</span>
				</a>
			</div>

			<div class="recommendation-item" id="item1">
				<a href="#">
					<div class="picture">
						<img src="img/sample.png" alt="">
						<p class="price">￥1,000</p>
					</div> <span class="item-name">商品5</span>
				</a>
			</div>
		</div>
	</div>
</body>
</html>