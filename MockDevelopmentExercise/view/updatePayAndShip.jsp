<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.*,dao.*"%>

<%
int userId = (Integer.parseInt(request.getParameter("userId")));
//buyerUserIdで買った商品のArrayListを検索
ArrayList<Item> boughtItemList = (ArrayList<Item>)request.getAttribute("buyItemList");

//sellerUserIdで売った商品のArrayListを検索
ArrayList<Item> seldItemList = (ArrayList<Item>)request.getAttribute("sellItemList");

int itemSituation = (Integer.parseInt(request.getParameter("itemSituation")));

String strItemSituation = "";
if(itemSituation == 0) {//これはこのページに表示しない
	strItemSituation = "出品中";
} else if (itemSituation == 1) {
	strItemSituation = "入金待ち";
} else if (itemSituation == 2) {
	strItemSituation = "発送待ち";
} else if (itemSituation == 3) {
	strItemSituation = "取引済";
}


%>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/updatePayment_Shipment.css">
    <title>神田雑貨店フリマ</title>
</head>
<body>
    <header>
        <nav class="nav-normal">
            <ul>
                <li class="logo">神田雑貨店</li>
                <li><a href="#">HOME</a></li>
                <li><a href="#">商品一覧</a></li>
                <li><input type="text" name="" id="" class="search" placeholder="なにをお探しですか？"><input type="button" value="🔍" class="search"></li>
                <li><div class="spacer"></div></li>
                <li><a href="#">マイページ</a></li>
                <li><a href="#">ログアウト</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
    	<!--購入商品-->
    	<h2>購入商品</h2>
        <div class="update-payment-shipment">
        <%
        	if(boughtItemList != null) {
        		for(int i = 0; i < boughtItemList.size(); i++) {
        			boughtItemList.get(i).getItemName();
        		}
        	}
        %>
        	<p>商品名：ネックレス</p>
        	<p>ステータス：入金済み</p><br>
        </div>
        <!--出品商品のうち売れたもの-->
        <h2>売れた商品</h2>
        <div class="update-payment-shipment">
        	<p>商品名：ネックレス</p>
        	<p>ステータス：発送済み</p><br>
        </div>
        <a href="#">マイページ</a>
    </div>
</body>
</html>