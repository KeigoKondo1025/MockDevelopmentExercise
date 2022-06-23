<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,bean.*,dao.*"%>

<%

//buyerUserIdで買った商品のArrayListを検索
ArrayList<Item> boughtItemList = (ArrayList<Item>)request.getAttribute("boughtItemList");

//sellerUserIdで売った商品のArrayListを検索
ArrayList<Item> soldItemList = (ArrayList<Item>)request.getAttribute("soldItemList");

int itemSituation = (Integer.parseInt(request.getParameter("itemSituation")));//NumberFormatException

String strItemSituation = "";
for (int i = 0; i < boughtItemList.size(); i++) {
	if (boughtItemList.get(i).getItemSituation() == 1) {
		strItemSituation = "入金待ち";
	} else if (boughtItemList.get(i).getItemSituation() == 2) {
		strItemSituation = "発送待ち";
	} else if (boughtItemList.get(i).getItemSituation() == 3) {
		strItemSituation = "取引済";
	}
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
    <%@include file="/common/header.jsp" %>
    <div class="container">
    	<!--購入商品-->
    	<h2>購入商品</h2>
        <div class="update-payment-shipment">
        	<form action="<%=request.getContextPath()%>/update">
        <%
        	if(boughtItemList != null) {
        		for(int i = 0; i < boughtItemList.size(); i++) {
        %>
        	<p>商品名：<%=boughtItemList.get(i).getItemName()%></p>
        	<p>ステータス：<%=strItemSituation%></p><br>
        	<p>
        <%	if (boughtItemList.get(i).getItemSituation() == 1) {%>
        	<input type="hidden" name="itemSituation" value="2">
        	<input type="hidden" name="itemId" value="<%=boughtItemList.get(i).getItemId()%>">
        	<input type="submit" name="pay" value="入金しました">
        <%}
        		}
        	}
        %>
			</form>
        </div>
        <!--出品商品のうち売れたもの-->
        <h2>売れた商品</h2>
        <div class="update-payment-shipment">
        	<form action="<%=request.getContextPath()%>/UpdatePayAndShip">
        	<%
        	if(soldItemList != null) {
        		for(int i = 0; i < soldItemList.size(); i++) {
        %>
        	<p>商品名：<%=soldItemList.get(i).getItemName()%></p>
        	<p>ステータス：<%=strItemSituation%></p><br>
        	<p>
        <%	if (boughtItemList.get(i).getItemSituation() == 2) {%>
        	<input type="hidden" name="itemSituation" value="3">
        	<input type="hidden" name="itemId" value="<%=soldItemList.get(i).getItemId()%>">
        	<input type="submit" name="ship" value="発送しました">
        <%}
        		}
        	}
        %>
        	</form>
        </div>
        <a href="<%=request.getContextPath()%>/MyPage">マイページ</a>
    </div>
</body>
</html>
