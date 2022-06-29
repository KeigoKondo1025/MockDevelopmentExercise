<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>

<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet "href="<%=request.getContextPath()%>/common/css/style.css">
<!-- 共通CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/common/css/menu.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/footer.css">
<!-- ヘッダーCSS -->
<title>Vicon エラーページ</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="container" align="center">
		<h2>■■エラー■■</h2>

		<!--エラーメッセージの表示 -->
		<p class="error-msg"><%=(String)request.getAttribute("error") %></p>

		<p>
			<%
			String cmd = (String)request.getAttribute("cmd");
			if(cmd.equals("index")){ %>
			<a href="<%=request.getContextPath()%>/Index">[トップページに戻る]</a>
			<%}else if(cmd.equals("logout")){ %>
				<a href="<%=request.getContextPath()%>/SignOut">[ログアウト]</a>
			<%} %>
		</p>
	</div>
</body>
</html>
