<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Item,util.MyFormat"%>
<%@page import="dao.IdToNameDAO"%>

<%
	ArrayList<Item> itemList = (ArrayList<Item>) request.getAttribute("item_list");//スコープ内の商品リストを取得
	MyFormat moneyFormat = new MyFormat();//金額表示用クラス
	IdToNameDAO idToNameDaoObj = new IdToNameDAO();

	//商品名取得
	String itemName = request.getParameter("item-name");

	//カテゴリー名取得
	String category = null;
	if (request.getParameter("category") != null) {
		if(!request.getParameter("category").equals("0")){
			category = idToNameDaoObj.categoryIdToName(Integer.parseInt(request.getParameter("category")));//カテゴリーIDからカテゴリー名取得
		}
	}

	//価格範囲取得
	String priceRange = null;
	if (request.getParameter("price-range") != null) {
		if(!request.getParameter("price-range").equals("0")){
		switch (Integer.parseInt(request.getParameter("price-range"))) {
		case 1:
			priceRange = "～999円";
			break;
		case 2:
			priceRange = "1,000円～2,999円";
			break;
		case 3:
			priceRange = "3,000円～4,999円";
			break;
		case 4:
			priceRange = "5,000円～9,999円";
			break;
		case 5:
			priceRange = "10,000円～";
			break;
		default:
			break;
		}
		}
	}

	//都道府県名取得
	String prefecture = null;
	if (request.getParameter("prefecture-id") != null) {
		if(!request.getParameter("prefecture-id").equals("0")){
			prefecture = idToNameDaoObj.prefectureIdToName(Integer.parseInt(request.getParameter("prefecture-id")));//都道府県IDから都道府県名を取得
		}
	}

%>

<html lang="ja">
<head>
<title>Vicon</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/style.css"><!-- 共通CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/menu.css"><!-- ヘッダーCSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/recommendation.css"><!-- 商品一覧CSS -->
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="container">
		<h1>商品一覧</h1>
		<h3>
			<%
				if (itemName != null) {
					if(!itemName.equals("")){
						out.print("商品名:"+itemName);
					}
				}
			%>
		</h3>
		<h3>
			<%
				if (category != null) {
					out.print("カテゴリー:"+category);
				}
			%>
		</h3>
		<h3>
			<%
				if (priceRange != null) {
					out.print("価格:"+priceRange);
				}
			%>
		</h3>
		<h3>
			<%
				if (prefecture != null) {
					out.print("出品地域:"+prefecture);
				}
			%>
		</h3>
		<div class="search-box">
			<form action="<%=request.getContextPath()%>/Search">
				<select name="category">
					<option value=0 selected>カテゴリー</option>
					<option value=1>服</option>
					<option value=2>本・音楽・ゲーム</option>
					<option value=3>家具・インテリア</option>
					<option value=4>食器</option>
					<option value=5>家電</option>
					<option value=6>おもちゃ・ホビー・グッズ</option>
					<option value=7>化粧品・香水</option>
					<option value=8>その他</option>
				</select> <select name="price-range">
					<option value=0 selected>価格</option>
					<option value=1>～999円</option>
					<option value=2>1,000円～2,999円</option>
					<option value=3>3,000円～4,999円</option>
					<option value=4>5,000円～9,999円</option>
					<option value=5>10,000円～</option>
				</select> <select name="prefecture-id" id="">
					<option value="0" selected>出品地域</option>
					<option value="1">1.北海道</option>
					<option value="2">2.青森県</option>
					<option value="3">3.岩手県</option>
					<option value="4">4.宮城県</option>
					<option value="5">5.秋田県</option>
					<option value="6">6.山形県</option>
					<option value="7">7.福島県</option>
					<option value="8">8.茨城県</option>
					<option value="9">9.栃木県</option>
					<option value="10">10.群馬県</option>
					<option value="11">11.埼玉県</option>
					<option value="12">12.千葉県</option>
					<option value="13">13.東京都</option>
					<option value="14">14.神奈川県</option>
					<option value="15">15.新潟県</option>
					<option value="16">16.富山県</option>
					<option value="17">17.石川県</option>
					<option value="18">18.福井県</option>
					<option value="19">19.山梨県</option>
					<option value="20">20.長野県</option>
					<option value="21">21.岐阜県</option>
					<option value="22">22.静岡県</option>
					<option value="23">23.愛知県</option>
					<option value="24">24.三重県</option>
					<option value="25">25.滋賀県</option>
					<option value="26">26.京都府</option>
					<option value="27">27.大阪府</option>
					<option value="28">28.兵庫県</option>
					<option value="29">29.奈良県</option>
					<option value="30">30.和歌山県</option>
					<option value="31">31.鳥取県</option>
					<option value="32">32.島根県</option>
					<option value="33">33.岡山県</option>
					<option value="34">34.広島県</option>
					<option value="35">35.山口県</option>
					<option value="36">36.徳島県</option>
					<option value="37">37.香川県</option>
					<option value="38">38.愛媛県</option>
					<option value="39">39.高知県</option>
					<option value="40">40.福岡県</option>
					<option value="41">41.佐賀県</option>
					<option value="42">42.長崎県</option>
					<option value="43">43.熊本県</option>
					<option value="44">44.大分県</option>
					<option value="45">45.宮崎県</option>
					<option value="46">46.鹿児島県</option>
					<option value="47">47.沖縄県</option>
				</select> <input type="text" placeholder="商品名" name="item-name"> <input
					type="submit" value="検索">
			</form>
		</div>
		<div class="recommendation">
			<%
				int count = 0;
				for (Item item : itemList) {
					count++;
			%>
			<div class="recommendation-item" id="item<%=count%>">
				<a
					href="<%=request.getContextPath()%>/ItemDetail?itemId=<%=item.getItemId()%>">
					<div class="picture">
						<img
							src="<%=request.getContextPath()%>/common/image/<%=item.getImage1()%>"
							alt="">
						<p class="price"><%=moneyFormat.moneyFormat(item.getPrice())%></p>
					</div> <span class="item-name"><%=item.getItemName()%></span>
				</a>
			</div>
			<%
				}
			%>
		</div>
		<div>
			<a href="<%=request.getContextPath()%>/view/itemEntry.jsp">出品</a>
		</div>
	</div>
</body>
</html>
