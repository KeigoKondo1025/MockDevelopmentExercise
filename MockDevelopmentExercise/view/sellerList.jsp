<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="java.util.ArrayList" %>

<%@page import="bean.*" %>
<%@page import="dao.*" %>

<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/style.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/userList.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/common/css/sellerList.css">

<%
request.setCharacterEncoding("UTF-8");
User sellerUser = (User)request.getAttribute("sellerUser");
ArrayList<User> sellerUserList = (ArrayList<User>)request.getAttribute("sellerUserList");

%>

<html>
<head>
<title>Vicon</title>
</head>
<body>

	<%@include file="/common/header.jsp"%>

	<div class="container">
		<h2>出品者一覧</h2>
		<div class="userlist_flex">
			<form action="#">
				ユーザー名：<input type=text size="10" name="">
				<input type="submit" name="search" value="検索">
			</form>
			<form action="#">
				<input type="submit" name="searchall" value="全件表示">
			</form>
		</div>

		<table class="sellerlist-table">
			<tr>
				<th>ユーザー名</th>
				<th>ユーザー一覧へ</th>
			</tr>

			<%
			if(sellerUser != null){
			%>
			<tr>
				<td><a href="<%= request.getContextPath() %>/UserList"><%= sellerUser.getUserName() %></a></td>
				<td><a href="<%= request.getContextPath() %>/UserList">出品一覧へ</a></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td><a href="#"></a></td>
				<!-- 仮置きなのでゲッター書いたら削除-->
				<td><a href="#">ユーザー一覧へ</a></td>
			</tr>
		</table>
	</div>
</body>
</html>