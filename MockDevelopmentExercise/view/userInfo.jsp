<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="bean.User" %>
<%@page import="dao.IdToNameDAO" %>


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

//都道府県名を受け取るメソッドの呼び出し
IdToNameDAO idToNameDao = new IdToNameDAO();
String prefecture = idToNameDao.prefectureIdToName(user.getPrefectureId());

%>

<html>
	<head>
		<title>Vicon</title>
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
					<td><%= prefecture %></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><%= user.getAddress1() + user.getAddress2() %></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><%= user.getMail() %></td>
				</tr>
				<tr>
					<th>生年月日</th>
					<td><%= user.getBirthday() %></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><%= user.getPhoneNumber() %></td>
				</tr>


			</table>

			<p><a href="<%= request.getContextPath() %>/MyPage">マイページ</a></p>
			<p><a href="<%= request.getContextPath() %>/view/changeUserInfo.jsp">ユーザ情報変更</a></p>

		</div>
	</body>

</html>
