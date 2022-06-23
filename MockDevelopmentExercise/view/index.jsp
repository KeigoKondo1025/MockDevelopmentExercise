<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Item,util.MyFormat"%>
<%
	ArrayList<Item> itemList = (ArrayList<Item>) request.getAttribute("item_list");//スコープ内の商品リストを取得
	MyFormat moneyFormat = new MyFormat();
%>

<html lang="ja">
<head>
<title>Vicon</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/recommendation.css">
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="container">
		<h1>商品一覧</h1>
		<div class="recommendation">
			<%
				int count = 0;
				for (Item item : itemList) {
					count++;
			%>
			<div class="recommendation-item" id="item<%=count%>">
				<a href="<%=request.getContextPath()%>/itemDetail?itemId=<%=item.getItemId()%>">
					<div class="picture">
						<img src="<%=request.getContextPath() %>/common/image/<%=item.getImage1()%>" alt="">
						<p class="price"><%=moneyFormat.moneyFormat(item.getPrice())%></p>
					</div>
					<span class="item-name"><%=item.getItemName()%></span>
				</a>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>