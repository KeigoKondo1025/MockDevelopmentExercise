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
			<li><a href="<%=request.getContextPath()%>/view/index.jsp">HOME</a></li>
			<li><a href="<%=request.getContextPath()%>/List">商品一覧</a></li>
			<li><input type="text" name="" id="" class="search"
				placeholder="なにをお探しですか？"><input type="button" value="🔍"
				class="search"></li>
			<li><div class="spacer"></div></li>
			<%if(authority == 0){ %>
				<li><a href="<%=request.getContextPath()%>/view/signUp.jsp">会員登録</a></li>
				<li><a href="<%=request.getContextPath()%>/view/signIn.jsp">ログイン</a></li>
			<%}else { %>
				<li><a href="<%=request.getContextPath()%>/MyPage">マイページ</a></li>
			<%} %>
		</ul>
	</nav>
</header>