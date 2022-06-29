<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.*,dao.*,util.*,java.util.*"%>

<%
ArrayList<Item> itemList = (ArrayList<Item>)request.getAttribute("itemList");

String strItemSituation = "";
%>


<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/userList.css">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/footer.css">
    <title>Vicon 商品一覧</title>
</head>
<body>
	<%@include file="/common/header.jsp" %>
    <div class="container">
	<h2>出品一覧</h2>
    	<div class="userlist_flex">
             <form action="<%=request.getContextPath()%>/Search">
                 金額：<select name="price">
                        <option value="1">0~999</option>
                        <option value="2">1000~2999</option>
                        <option value="3">3000~4999</option>
                        <option value="4">5000~9999</option>
                        <option value="5">10000~</option>
                 </select>円

                 取引情報：<select name="itemSituation">
                                <option value="0">出品中</option>
                                <option value="1">入金待ち</option>
                                <option value="2">発送待ち</option>
                                <option value="3">取引済</option>
                            </select>
				 <input type="hidden" name="cmd" value="itemSearch">
                 <input type="submit" name="search" value="検索">
              </form>
              <form action="<%=request.getContextPath()%>/ItemList"method="post">
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
            <%
            UserDAO userDao = new UserDAO();
            if (itemList != null) {
            	for(int i = 0; i < itemList.size(); i++) {

            		if (itemList.get(i).getItemSituation() == 0) {
            			strItemSituation = "出品中";
            		} else if (itemList.get(i).getItemSituation() == 1) {
        				strItemSituation = "入金待ち";
        			} else if (itemList.get(i).getItemSituation() == 2) {
        				strItemSituation = "発送待ち";
        			} else if (itemList.get(i).getItemSituation() == 3) {
        				strItemSituation = "取引済";
        			} else if (itemList.get(i).getItemSituation() == 4) {
						strItemSituation = "出品停止";
        			}
            		User sellerUser = userDao.searchByUserId(itemList.get(i).getSellerId());
            %>
            <tr>
                <td>
                	<a href="<%= request.getContextPath() %>/SellerList?userId=<%= itemList.get(i).getSellerId() %>"><%= sellerUser.getUserName() %></a>
                </td>
                <td><a href="<%=request.getContextPath()%>/SalesList"><%=itemList.get(i).getItemName() %></a></td>
                <td><%=itemList.get(i).getPrice() %></td>
                <td><%=strItemSituation%></td>
                <td>
                	<%if (itemList.get(i).getDeleteFlag() == false) {%>
                	<form action="<%=request.getContextPath()%>/ItemDelete" method="post">
                		<input type="hidden" name="itemId" value="<%=itemList.get(i).getItemId()%>">
                		<input type="hidden" name="deleteFlag" value="<%=itemList.get(i).getDeleteFlag()%>">
                		<input type="submit" name="delete" value="取り下げ">
                	</form>
                	<%} %>
                </td>
            </tr>
            <%
            	}
            }
            %>
            <!-- 繰り返し処理ここまで-->
        </table>
    </div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>
