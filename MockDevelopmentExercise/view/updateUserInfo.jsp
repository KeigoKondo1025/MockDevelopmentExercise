<%@page contentType= "text/html; charset=UTF-8" %>
<%@page import="bean.User" %>
<%
User user = (User)request.getAttribute("userInfo");
%>
<html>
	<head>
		<title>ユーザー情報変更</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/menu.css">
	</head>
	<body>
		<header>
			<nav class="nav-nomal">
				<ul>
					<li class="logo">Vicom</li>
					<li><a href="#">HOME</a></li>
					<li><a href="#"></a>商品一覧</li>
					<li><input type="text" name="" id="" class="search" placeholder="何をお探しですか？"><input type="button" value="🔍" class="search"></li>
					<li><div class="spacer"></div></li>
				</ul>
			</nav>
		</header>
		<div class="container">
			<h2>ユーザー情報変更</h2>
			<form action="<%=request.getContextPath() %>/UpdateUserInfoServlet">
				<table>
					<tr>
						<td>変更前</td>
						<td>変更後</td>
					</tr>
					<%
						if(user != null){
					%>
					<tr>
						<td>ユーザー名</td>
						<td><%= user.getUserName() %></td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>本名</td>
						<td><%= user.getFamilyName() %><%= user.getFirstName() %></td>
						<th><input type="text" name="familyName"><input type="text" name="firstName"></th>
					</tr>
					<tr>
						<td>性別</td>
						<td><%= user.getGender() %></td>
						<td>
							<input type="radio" name="gender" value="1">男
							<input type="radio" name="gender" value="2">女
							<input type="radio" name="gender" value="3">その他
						</td>
					</tr>
					<tr>
						<td>郵便番号</td>
						<td>〒<%= user.getPostal_code() %></td>
						<td>〒<input type>
					<%
						}
					%>
				</table>
			</form>
		</div>
	</body>
</html>