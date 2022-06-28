<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.Item,dao.IdToNameDAO,util.MyFormat"%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/itemDetail.css">
    <title>商品詳細</title>
</head>
<body>
   <%@include file="/common/header.jsp"%>

	<%
		Item item = (Item)request.getAttribute("item"); 	// リクエストスコープに登録された商品情報を取得
		MyFormat myFormat = new MyFormat(); 		// 金額表示を変えるMyFormatクラスをオブジェクト化
		IdToNameDAO idToNameDao = new IdToNameDAO();	// カテゴリ名を取得するメソッド利用のため、DAOクラスをオブジェクト化
	%>

    <div class="container">
        <h1><%=item.getItemName()%></h1>
          <div class="item-detail">

            <div class="item-img-box">
                <img src="<%=request.getContextPath()%>/common/image/item.getImage1()" alt="" class="item-img">
                <img src="<%=request.getContextPath()%>/common/image/item.getImage2()" alt="" class="item-img">
                <img src="<%=request.getContextPath()%>/common/image/item.getImage3()" alt="" class="item-img">
                <img src="<%=request.getContextPath()%>/common/image/item.getImage4()" alt="" class="item-img">
            </div>

            <div class="item-info">
                <form action="<%=request.getContextPath() %>/Favorite" method="get">
                	<span class="price"><%= myFormat.moneyFormat(item.getPrice()) %></span>
                	<input type="hidden"  name="cmd" value="insert">
			<input type="hidden"  name="itemId" value="<%=item.getItemId() %>">
                	<input type="submit" value="お気に入り" class="favorite">
                </form>
                <br>
                <span class="category"><%=idToNameDao.categoryIdToName(item.getCategoryId()) %></span>
                <div class="item-text">
                    <p class="text"><%=item.getSellerMessage() %></p>
                </div>
                <form action="<%=request.getContextPath() %>/BuyItem" method="get">
                	<input type="submit" value="購入する" class="buy-btn">
			<input type="hidden"  name="itemId" value="<%=item.getItemId() %>">
                </form>
            </div>

          </div>
    </div>
</body>
</html>
