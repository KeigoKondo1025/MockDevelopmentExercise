<%@page contentType= "text/html;charset=UTF-8" %>
<%@page import="java.util.Date, java.text.SimpleDateFormat, bean.User" %>
<%
User user = (User)session.getAttribute("user");
%>
<html>
	<head>
		<title>Vicon 商品出品</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/menu.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/itemEntry.css">
	</head>
	<body>
		<%@include file="../common/header.jsp" %>
		<div class="container">
			<div class="itemEntry">
				<%
				if (user == null){
					request.getRequestDispatcher("/view/signIn.jsp").forward(request, response);
				}
				%>
				<form action="<%=request.getContextPath() %>/ItemEntry">
				<p>商品のアップロード</p>
				<input type="file" name="image1" accept="image/*"><br><br>
				<input type="file" name="image2" accept="image/*"><br><br>
				<input type="file" name="image3" accept="image/*"><br><br>
				<input type="file" name="image4" accept="image/*">
				<p>商品名</p>
				<input type="text" name="itemName">
				<p>カテゴリ</p>
				<select name="categoryId">
					<option value="1" selected>服</option>
					<option value="2">本・音楽・ゲーム</option>
					<option value="3">家具・インテリア</option>
					<option value="4">食器</option>
					<option value="5">家電</option>
					<option value="6">おもちゃ・ホビー・グッズ</option>
					<option value="7">化粧品・香水</option>
					<option value="8">その他</option>
				</select>
				<p>価格</p>
				<input type="text" name="price">
				<p>商品状態</p>
				<select name="itemState">
					<option value="1" selected>新品</option>
					<option value="2">中古</option>
					<option value="3">汚れあり</option>
					<option value="4">破損あり</option>
				</select>
				<p>出品者メッセージ</p>
				<textarea name="sellerMessage" rows="3" cols="30"></textarea>
				<p>出品地域</p>
				<select name="prefectureId">
					<option value="1">北海道</option>
					<option value="2">青森県</option>
					<option value="3">岩手県</option>
					<option value="4">宮城県</option>
					<option value="5">秋田県</option>
					<option value="6">山形県</option>
					<option value="7">福島県</option>
					<option value="8">茨城県</option>
					<option value="9">栃木県</option>
					<option value="10">群馬県</option>
					<option value="11">埼玉県</option>
					<option value="12">千葉県</option>
					<option value="13">東京都</option>
					<option value="14">神奈川県</option>
					<option value="15">新潟県</option>
					<option value="16">富山県</option>
					<option value="17">石川県</option>
					<option value="18">福井県</option>
					<option value="19">山梨県</option>
					<option value="20">長野県</option>
					<option value="21">岐阜県</option>
					<option value="22">静岡県</option>
					<option value="23">愛知県</option>
					<option value="24">三重県</option>
					<option value="25">滋賀県</option>
					<option value="26">京都府</option>
					<option value="27">大阪府</option>
					<option value="28">兵庫県</option>
					<option value="29">奈良県</option>
					<option value="30">和歌山県</option>
					<option value="31">鳥取県</option>
					<option value="32">島根県</option>
					<option value="33">岡山県</option>
					<option value="34">広島県</option>
					<option value="35">山口県</option>
					<option value="36">徳島県</option>
					<option value="37">香川県</option>
					<option value="38">愛媛県</option>
					<option value="39">高知県</option>
					<option value="40">福岡県</option>
					<option value="41">佐賀県</option>
					<option value="42">長崎県</option>
					<option value="43">熊本県</option>
					<option value="44">大分県</option>
					<option value="45">宮崎県</option>
					<option value="46">鹿児島県</option>
					<option value="47">沖縄県</option>
				</select>
				<input type="hidden" name="itemSituation" value="0">
				<input type="hidden" name="deleteFlag" value="false">
				<br><br>
				<input type="submit" value="出品">
				</form>
			</div>
		</div>
	</body>
</html>
