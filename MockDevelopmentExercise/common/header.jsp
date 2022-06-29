<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.User"%>
<%
	session = request.getSession();
	int authority = 0;
	if(session.getAttribute("user") != null){
	authority= ((User)session.getAttribute("user")).getAuthority();
	}
%>
<header>
	<nav class="nav-normal <%if(authority == 2){out.print("nav-admin");}%>">
		<ul>
			<li class="logo">Vicon</li>
			<li><a href="<%=request.getContextPath()%>/Index">HOME</a></li>
			<li>
				<form action="<%=request.getContextPath() %>/Search" method = "get">
					<input type="text" name="item-name" id="" class="search" placeholder="なにをお探しですか？">
					<input type="submit" value="🔍" class="search">
					<input type="hidden" name="cmd" value="">
					<input type="hidden" name="category" value="0">
					<input type="hidden" name="price-range" value="0">
					<input type="hidden" name="prefecture-id" value="0">
				</form>
			</li>
			<li><div class="spacer"></div></li>
			<%if(authority == 0){ %>
				<li><a href="<%=request.getContextPath()%>/view/signUp.jsp">会員登録</a></li>
				<li><a href="<%=request.getContextPath()%>/view/signIn.jsp">ログイン</a></li>
			<%}else { %>
				<li><a href="<%=request.getContextPath()%>/MyPage">マイページ</a></li>
				<li><a href="<%=request.getContextPath() %>/SignOut">ログアウト</a></li>
			<%} %>
		</ul>
	</nav>
</header>