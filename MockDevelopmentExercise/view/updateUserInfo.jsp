<%@page contentType= "text/html;charset=UTF-8" %>
<%@page import="bean.User, java.sql.Date, java.text.*, dao.IdToNameDAO" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/userInfo.css">

<%
User userinfo = (User)session.getAttribute("user");
String prefectureName = null;
%>
<html>
	<head>
		<title>Vicon ユーザー情報変更</title>

	</head>
	<body>
		<%@include file="../common/header.jsp" %>
		<div class="container">
			<h2>ユーザー情報変更</h2>
			<form action="<%=request.getContextPath() %>/UpdateUserInfo" method="post">
				<%
					if(userinfo != null){
				%>
				<table class="userinfo-table">
					<tr>
						<th></th>
						<td>変更前</td>
						<td>変更後</td>
					</tr>

					<tr>
						<th>ユーザー名</th>
						<td><%= userinfo.getUserName() %></td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<th>苗字</th>
						<td><%= userinfo.getFamilyName() %></td>
						<th><input type="text" name="familyName"></th>
					</tr>
					<tr>
						<th>名前</th>
						<td><%= userinfo.getFirstName() %></td>
						<td><input type="text" name="firstName"></td>
					</tr>
					<tr>
						<th>郵便番号</th>
						<td>〒<%= userinfo.getPostalCode() %></td>
						<td>〒<input type="text" name="postalCpde"></td>
					</tr>
					<tr>
						<th>都道府県</th>
						<%
							IdToNameDAO idToNameDao = new IdToNameDAO();
							prefectureName = idToNameDao.prefectureIdToName(userinfo.getPrefectureId());
						%>
						<td><%= prefectureName %></td>
						<td>
							<select name="prefectureCode">
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
						</td>
					</tr>
					<tr>
						<th>住所1</th>
						<td><%= userinfo.getAddress1() %></td>
						<td><input type="text" name="address1"></td>
					</tr>
					<tr>
						<th>住所2</th>
						<td><%=userinfo.getAddress2() %></td>
						<td><input type="text" name="address2"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><%= userinfo.getMail() %></td>
						<td><input type="text" name="mail"></td>
					</tr>
					<tr>
					<tr>
						<th>電話番号</th>
						<td><%= userinfo.getPhoneNumber() %></td>
						<td><input type="text" name="phoneNumber"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><%= userinfo.getPassWord() %></td>
						<td><input type="text" name="pass"></td>
					</tr>
				</table>
				<input type="hidden" name="userId" value="<%=userinfo.getUserId() %>">
				<input type="hidden" name="mail" value="<%=userinfo.getMail() %>">
				<input type="hidden" name="authority" value="<%=userinfo.getAuthority() %>">
				<input type="hidden" name="userId" value="<%=userinfo.getUserId() %>">
				<%
					}
				%>
				<input type="submit" value="確定">
			</form>
		</div>
	</body>
</html>
