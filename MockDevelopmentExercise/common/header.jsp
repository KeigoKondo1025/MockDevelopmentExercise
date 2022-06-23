<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.User"%>
<%
	session = request.getSession();
	User user = (User) session.getAttribute("user");
%>
<header>
	<nav class="nav-normal">
		<ul>
			<li class="logo">Vicon</li>
			<li><a href="#">HOME</a></li>
			<li><a href="#">商品一覧</a></li>
			<li><input type="text" name="" id="" class="search"
				placeholder="なにをお探しですか？"><input type="button" value="🔍"
				class="search"></li>
			<li><div class="spacer"></div></li>
			<%if(user == null){ %>
				<li><a href="#">会員登録</a></li>
				<li><a href="#">ログイン</a></li>
			<%}else { %>
				<li><a href="<%=request.getContextPath()%>/MyPage">マイページ</a></li>
			<%} %>
		</ul>
	</nav>
</header>