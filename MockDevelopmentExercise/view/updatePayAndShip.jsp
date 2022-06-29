<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,bean.*,dao.*"%>

<%

//buyerUserIdで買った商品のArrayListを検索
ArrayList<Item> buyItemList = (ArrayList<Item>)request.getAttribute("buyItemList");

//sellerUserIdで売った商品のArrayListを検索
ArrayList<Item> sellItemList = (ArrayList<Item>)request.getAttribute("sellItemList");

int itemSituation;

String strItemSituation = "";

%>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/updatePayment_Shipment.css">
    <title>神田雑貨店フリマ</title>
</head>
<body>
    <%@include file="/common/header.jsp" %>
    <div class="container">
    	<!--購入商品-->
    	<h2>購入商品</h2>

        <%
        	if(buyItemList != null) {
        		for(int i = 0; i < buyItemList.size(); i++) {
        			if (buyItemList.get(i).getItemSituation() == 1) {
        				strItemSituation = "入金待ち";
        			} else if (buyItemList.get(i).getItemSituation() == 2) {
        				strItemSituation = "発送待ち";
        			} else if (buyItemList.get(i).getItemSituation() == 3) {
        				strItemSituation = "取引済";
        			}
        %>
        	<div class="update-payment-shipment">
	        	<p>商品名：<%=buyItemList.get(i).getItemName()%></p>
	        	<p>ステータス：<%=strItemSituation%></p>
        	</div>

        <%
        if(buyItemList.get(i).getItemSituation() == 1) {
        %>
        <form class="update-payment-shipment" action="<%=request.getContextPath()%>/UpdatePayAndShip" method="post">
        	<input type="hidden" name="itemSituation" value="2">
        	<input type="hidden" name="itemId" value="<%=buyItemList.get(i).getItemId()%>">
        	<input type="submit" name="pay" value="入金しました">
        </form>
        <%			}
        		}
        	}
        %>
		</div>

    <div class="container" id="update-payment-dosplay">
        <!--出品商品のうち売れたもの-->
        <h2>売れた商品</h2>

        	<%
        	if(sellItemList != null) {
        		for(int i = 0; i < sellItemList.size(); i++) {
        			if (sellItemList.get(i).getItemSituation() == 1) {
        				strItemSituation = "入金待ち";
        			} else if (sellItemList.get(i).getItemSituation() == 2) {
        				strItemSituation = "発送待ち";
        			} else if (sellItemList.get(i).getItemSituation() == 3) {
        				strItemSituation = "取引済";
        			}
        %>
        	<div class="update-payment-shipment">
	        	<p>商品名：<%=sellItemList.get(i).getItemName()%></p>
	        	<p>ステータス：<%=strItemSituation%></p>
        	</div>

        <%	if (sellItemList.get(i).getItemSituation() == 2) {%>
        	<form class="update-payment-shipment" action="<%=request.getContextPath()%>/UpdatePayAndShip" method="post">
	        	<input type="hidden" name="itemSituation" value="3">
	        	<input type="hidden" name="itemId" value="<%=sellItemList.get(i).getItemId()%>">
	        	<input type="submit" name="ship" value="発送しました">
        	</form>
        <%		}
        	}
        }
        %>

        </div>

</body>
</html>
