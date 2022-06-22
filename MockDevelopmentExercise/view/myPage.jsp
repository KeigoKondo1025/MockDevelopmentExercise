<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/menu.css">
	<link rel="recommendation" href="css/recommendation.css">
	<title>神田雑貨店フリマ マイページ</title>
</head>
<body>
	<header>
        <nav class="nav-normal">
            <ul>
                <li class="logo">神田雑貨店</li>
                <li><a href="">HOME</a></li>
                <li><a href="#">商品一覧</a></li>
                <li><input type="text" name="" id="" class="search" placeholder="なにをお探しですか？"><input type="button" value="🔍" class="search"></li>
                <li><div class="spacer"></div></li>
                <li><a href="/SignOutServlet">ログアウト</a></li>
            </ul>
        </nav>
    </header>
	<div class="container">

		<h1>マイページ</h1>
		<div class="menu">
			<h3 class="user-name" >ユーザーさん<h3>
			<!-- 出品している商品を一覧で表示 -->
		<div class="container">

		<p class="favorite-list"><a href="#">お気に入り一覧</a></p>
		<p class="updatePayment-Shipment"><a href="#">入金状況／発送確認</a></p>
		<p class="userInfo"><a href="#">ユーザ情報</a></p>
		<h4>出品商品一覧</h4>

		<div class="item-list">
			<div class="recommendation-item" id="item1">
				<a href="#">
				<div class="picture">
					<img src="img/sample.png" alt="">
					<p class="price">￥1,000</p>
				</div>
				<span class="item-name">商品1</span>
				</a>
			</div>

			<div class="recommendation-item" id="item2">
				<a href="#">
				<div class="picture">
					<img src="img/sample.png" alt="">
					<p class="price">￥1,000</p>
				</div>
				<span class="item-name">商品2</span>
				</a>
			</div>

			<div class="recommendation-item" id="item3">
				<a href="#">
				<div class="picture">
					<img src="img/sample.png" alt="">
					<p class="price">￥1,000</p>
				</div>
				<span class="item-name">商品3</span>
				</a>
			</div>

			<div class="recommendation-item" id="item4">
				<a href="#">
				<div class="picture">
					<img src="img/sample.png" alt="">
					<p class="price">￥1,000</p>
				</div>
				<span class="item-name">商品4</span>
				</a>
			</div>

			<div class="recommendation-item" id="item5">
				<a href="#">
				<div class="picture">
					<img src="img/sample.png" alt="">
					<p class="price">￥1,000</p>
				</div>
				<span class="item-name">商品5</span>
				</a>
			</div>


		</div>
	</div>
</body>
</html>
