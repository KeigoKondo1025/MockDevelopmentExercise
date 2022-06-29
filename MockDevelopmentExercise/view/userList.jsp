<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.*,dao.*,util.*,java.util.*"%>

<%
ArrayList<User> list = (ArrayList<User>)request.getAttribute("userList");
%>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/itemEntry.css">
    	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/userList.css">
        <title>Vicon ユーザ一覧</title>
</head>
<body>
	<%@include file="/common/header.jsp" %>
    <div class="container">
			<h2>ユーザー一覧</h2>
			<div class="userlist_flex">
				<form action="<%= request.getContextPath() %>/UserSearch" method="get">
					ユーザー名：<input type=text size="10" name="userName">
                     			<input type="submit" value="検索">
				</form>

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
                <th>削除/利用停止</th>
            </tr>

            <%
            if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					User user = list.get(i);

					// 性別の判定
					String gender = "";		// 性別を表す文字列を格納する変数
					//性別の判定
					if(user.getGender() == 1){
						gender = "男";
					}else if(user.getGender() == 2){
						gender = "女";
					}else {
						gender = "その他";
					}
			%>
            <tr>
                <td><%= user.getFamilyName()%><%= user.getFirstName()%></td>
                <td><%= user.getUserName()%></td>
                <td><%= gender%></td>
                <td><%= user.getBirthday()%></td>
                <td>
                	<div class="userlist_flex">
				<form action="<%=request.getContextPath()%>/UserDelete">
					<input type="submit" value="削除">
					<input type="hidden" name="userId" value=<%=user.getUserId()%>>
				</form>

				<form  action="<%=request.getContextPath()%>/UserBan">
					<input type="submit" value="<%if(user.getIsUserBanned() == false){out.print("利用停止");}
					else if(user.getIsUserBanned() == true){out.print("停止解除");}%>">
					<input type="hidden" name="userId" value=<%=user.getUserId()%>>
				</form>
                	</div>
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
