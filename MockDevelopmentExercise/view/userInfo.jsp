<%@page contentType= "text/html; charset=UTF-8" %>

<%@page import="bean.User" %>


<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/userInfo.css">

<%
request.setCharacterEncoding("UTF-8");
User user = (User)request.getAttribute("user");


//性別を格納する変数
String gender = "";
//性別の判定
if(user.getGender() == 1){
	gender = "男";
}else if(user.getGender() == 2){
	gender = "女";
}else {
	gender = "その他";
}
%>

<html>
	<head>
		<title>userInfo</title>
	</head>
	<body>

		<%@include file="/common/header.jsp" %>
		<div class="container">
			<h2>ユーザ情報</h2>
			<table class="userinfo-table">
				<tr>
					<th>本名</th>
					<td><%= user.getFamilyName() + " " +user.getFirstName() %></td>
				</tr>
				<tr>
					<th>性別</th>
					<td><%= gender %></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td>〒<%= user.getPostalCode() %></td>
				</tr>
				<tr>
					<th>都道府県</th>
					<td>東京都</td>
				</tr>
				<tr>
					<th>住所</th>
					<td>千代田区ホニャホニャ1丁目</td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td>kandataro@kanda.com</td>
				</tr>
				<tr>
					<th>生年月日</th>
					<td>2000年1月1日</td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td>08011112222</td>
				</tr>


			</table>
			<form>
				<a href="/myPage">マイページ</a><br> <a href="/changeUserInfo">ユーザ情報変更</a>
			</form>
		</div>
	</body>

</html>