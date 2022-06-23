<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.*,dao.*,util.*"%>

<%
//
%>


<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/common/css/menu.css">
    <link rel="stylesheet" href="/common/css/style.css">
    <link rel="stylesheet" href="/common/css/userList.css">
    <title>神田雑貨店フリマ</title>
</head>
<body>
	<%@include file="/common/header.jsp" %>
    <div class="container">
	<h2>出品一覧</h2>
    <table align = "center">
    	<div class="userlist_flex">
             <form action="">
                 ユーザー名：<input type=text size="10" name="">
                 金額：<select name="price">
                        <option value="">300~999</option>
                        <option value="">1000~1500</option>
                        <option value="">1500~2000</option>
                        <option value="">2000~2500</option>
                        <option value="">2500~3000</option>
                        <option value="">3000~</option>
                 </select>円

                 取引情報：<select name="itemSituation">
                                <option value="0">出品中</option>
                                <option value="1">入金待ち</option>
                                <option value="2">発送待ち</option>
                                <option value="3">取引済</option>
                            </select>
                 <input type="submit" name="search" value="検索">
              </form>
              <form action="">
                   <input type="submit" name="searchall" value="全件表示">
              </form>
         </div>

        <table class="userlist-table">
            <tr>
                <th>ユーザー名</th>
                <th>商品名</th>
                <th>金額</th>
                <th>取引情報</th>
                <th>強制取り下げ</th>
            </tr>

            <!-- 繰り返し処理ここから-->
            <tr>
                <td>konan_edogawa</td><!-- 仮置きなのでゲッター書いたら削除-->
                <td>腕時計型麻酔銃</td>
                <td>1200円</td><!-- 仮置きなのでゲッター書いたら削除-->
                <td>出品中</td><!-- 仮置きなのでゲッター書いたら削除-->
                <td><a href="<%=request.getContextPath()%>/ItemDelete">取り下げ</a></td>
            </tr>
            <!-- 繰り返し処理ここまで-->
        </table>
    </div>
</body>
</html>