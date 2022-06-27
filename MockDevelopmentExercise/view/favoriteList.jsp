<%@page contentType="text/html;charset=UTF-8"%>
<%@page
	import="java.util.ArrayList,bean.User,bean.Item,dao.ItemDAO,dao.FavoriteDAO,util.MyFormat"%>
<%@page session="true"%>
<%
	User user = (User) session.getAttribute("user");
	MyFormat moneyFormat = new MyFormat();
%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/common/css/menu.css">
<link rel="recommendation"
	href="<%=request.getContextPath()%>/common/css/recommendation.css">
<title>Vicon</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>

	<div class="container">
		<h1>お気に入り商品</h1>

		<div class="recommendation">
			<%
				ArrayList<Item> favoriteList = (ArrayList<Item>) request.getAttribute("favoriteList");
				if (favoriteList != null) {
					int count = 0;
					for (int i = 0; i < favoriteList.size(); i++) {
						count++;
			%>
			<div class="recommendation-item" id="<%=count%>">
				<a
					href="<%=request.getContextPath()%>/ItemDetail?itemId=<%=favoriteList.get(i).getItemId()%>">
					<div class="picture">
						<img
							src="<%=request.getContextPath()%><%=favoriteList.get(i).getImage1()%>"
							alt="NO IMAGE">
						<p class="price"><%=moneyFormat.moneyFormat(favoriteList.get(i).getPrice())%></p>
					</div> <span class="item-name"><%=favoriteList.get(i).getItemName()%></span>
				</a>
				<form action="<%=request.getContextPath() %>/Favorite" method="get">
					<input type="hidden" name="cmd" value="delete"> <input
						type="hidden" name="itemId"
						value="<%=favoriteList.get(i).getItemId() %>"> <input
						type="submit" value="削除" class="favorite">
					</form>
			</div>
		</div>
		<%
			}
			} else {
		%>
		<br>NO Item <br>
		<%
			}
		%>
	</div>
</body>
</html>