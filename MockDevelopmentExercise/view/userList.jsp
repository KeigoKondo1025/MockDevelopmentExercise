<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.*,dao.*,util.*,java.util.*"%>

<%
ArrayList<User> itemList = (ArrayList<User>)request.getAttribute("userList");
%>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/itemEntry.css">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/userList.css">
        <title>神田雑貨店フリマ</title>
</head>
<body>
	<%@include file="/common/header.jsp" %>
    <div class="container">
    	<div class="userList">
			<h2>ユーザー一覧</h2>
			<div class="userlist-search">
				<form action="<%= request.getContextPath() %>/UserList" method="get">
                     本名：<input type=text size="10" name="">
                     ユーザー名：<input type=text size="10" name="">
                     性別：<select name="">
                                    <option value="">男</option>
                                    <option value="">女</option>
                                    <option value="">その他</option>
                                </select>

					誕生年：<select name="birth-year"><!-- 年で絞りたいこともあると思うので仮で月だけをおいています-->
                            	<select name="birth-year">
									<option value="">-</option>
									<option value="1">1900~1910</option>
									<option value="2">1911~1920</option>
									<option value="3">1921~1930</option>
									<option value="4">1931~1940</option>
									<option value="5">1941~1950</option>
									<option value="6">1951~1960</option>
									<option value="7">1961~1970</option>
									<option value="8">1970~1980</option>
									<option value="9">1980~1990</option>
									<option value="10">1991~2000</option>
									<option value="11">2001~2010</option>
									<option value="12">2011~2022</option>
								</select>　年
                     <input type="submit" name="searchYear" value="検索">

                     <form action="<%= request.getContextPath() %>/UserList" method="get">
						<input type="submit" name="searchAll" value="全件表示">
					</form>
			</div>


        <table class="userlist-table">
            <tr>
                <th>本名</th>
                <th>ユーザー名</th>
                <th>性別</th>
                <th>生年月日</th>
                <th>ユーザーの削除/利用停止</th>
            </tr>
            <!--繰り返し表示する処理ここから-->
            <%
			ArrayList<User> list = (ArrayList<User>) request.getAttribute("userList");
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					User user = list.get(i);
			%>
            <tr>
                <td>江戸川コナン</td><!-- 仮置きなのでゲッター書いたら削除-->
                <td><a href="#">konan_edogawa</a></td><!--  ユーザー情報へ -->
                <td>男</td><!-- 仮置きなのでゲッター書いたら削除-->
                <td>2022/6/21</td><!-- 仮置きなのでゲッター書いたら削除-->
                <td>
                <a href="">削除</a>
                <a href="">利用停止</a>
                </td>
            </tr>
            <%
				}
			}else{
			%>
			<p style="text-align:center">表示するデータがありません。</p>
			<%
			}
			%>
        </table>
    </div>
    </body>
</html>