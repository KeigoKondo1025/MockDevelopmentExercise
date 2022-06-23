<%@page contentType="text/html;charset=UTF-8"%>

<%
	String mail = "";
	String password = "";

	//入力が間違っていた時
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}

	Cookie[] userCookie = request.getCookies();
	if (userCookie != null) {
		for (int i = 0; i < userCookie.length; i++) {
			if (userCookie[i].getName().equals("mail")) {
				mail = userCookie[i].getValue();
			}
			if (userCookie[i].getName().equals("password")) {
				password = userCookie[i].getValue();
			}
		}
	}
%>

<html lang="ja">
<head>
<title>神田雑貨店フリマ</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="container">
		<h2 align="center">ログイン</h2>

		<form action="<%=request.getContextPath()%>/SignIn" method="post">
			<table align="center">
				<tr>
					<td>メールアドレス</td>
					<td><input type=text size="20" name="mail"></td>
					<!--メールアドレス入力-->
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type=password size="20" name="password"></td>
					<!--password入力-->
			</table>
			<p align="center"><%=message%></p>
			<p align="center">
				<input type="submit" value="ログイン">
			</p>
		</form>
	</div>
</body>
</html>