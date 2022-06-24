<%@page contentType= "text/html; charset=UTF-8" %>
<%@page import="bean.User, java.sql.Date, java.text.*, dao.IdToNameDAO" %>
<%
User userinfo = (User)request.getAttribute("userInfo");
String prefectureName = null;
%>
<html>
	<head>
		<title>ユーザー情報変更</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/style.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/common/css/menu.css">
	</head>
	<body>
		<%@include file="../common/header.jsp" %>
		<div class="container">
			<h2>ユーザー情報変更</h2>
			<form action="<%=request.getContextPath() %>/UpdateUserInfo" method="post">
				<table>
					<tr>
						<td>変更前</td>
						<td>変更後</td>
					</tr>
					<%
						if(userinfo != null){
					%>
					<tr>
						<td>ユーザー名</td>
						<td><%= userinfo.getUserName() %></td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>本名</td>
						<td><%= userinfo.getFamilyName() %><%= userinfo.getFirstName() %></td>
						<th><input type="text" name="familyName"><input type="text" name="firstName"></th>
					</tr>
					<tr>
						<td>性別</td>
						<td><%= userinfo.getGender() %></td>
						<td>
							<input type="radio" name="gender" value="1">男
							<input type="radio" name="gender" value="2">女
							<input type="radio" name="gender" value="3">その他
						</td>
					</tr>
					<tr>
						<td>郵便番号</td>
						<td>〒<%= userinfo.getPostalCode() %></td>
						<td>〒<input type="text" name="postalCpde1" size="4"><input type="text" name="postalCode2" size="5"></td>
					</tr>
					<tr>
						<td>都道府県</td>
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
						<td></td>
						<td><%= userinfo.getAddress1() %></td>
						<td><input type="text" name="address1"></td>
					</tr>
					<tr>
						<td>メールアドレス</td>
						<td><%= userinfo.getMail() %></td>
						<td><input type="text" name="mail"></td>
					</tr>
					<tr>
						<td>生年月日</td>
						<% String birthday = new SimpleDateFormat("yyyy年mm月dd").format(userinfo.getBirthday()); %>
						<td><%= birthday %></td>
						<td><input type="date" name="birthday"></td>
					</tr>
					<tr>
						<td>電話番号</td>
						<td><%= userinfo.getPhoneNumber() %></td>
						<td><input type="text" name="phoneNumber"></td>
					</tr>
					<%
						}
					%>
				</table>
				<input type="submit" value="確定">
			</form>
		</div>
	</body>
</html>