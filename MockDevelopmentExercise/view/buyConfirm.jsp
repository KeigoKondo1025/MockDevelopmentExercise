<%@page contentType= "text/html;charset=UTF-8" %>
<html>
	<head>
		<title>購入確認</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/menu.css">
	</head>
	<body>
		<%@include file="../common/header.jsp" %>
		<div class="container">
			<p>ご購入ありがとうございます！<br>
				メールを送信しましたのでご確認ください。<br>
			</p>
			<br>
			<a href="<%= request.getContextPath() %>/MyPage">トップページ</a>
		</div>
	</body>
</html>