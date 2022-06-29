 <%@page contentType="text/html;charset=UTF-8"%>
 <%@page import="java.util.Date,java.text.SimpleDateFormat"%>

 <html lang="ja">
 <head>
 	<meta charset="UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/menu.css">
 	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css">
 	<link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/signUp.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/footer.css">
 	<script src="<%=request.getContextPath() %>/common/js/signUp.js" charset="UTF-8"></script>
 	<title>Vicon 会員登録</title>
 	<%
 		Date date = new Date();
 		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 	%>
 </head>
 <body>
 	<%@include file="/common/header.jsp"%>

 	<div class="container">
 		<div class="signup-form">
 			<h1>会員登録</h1>
 		<form action="<%=request.getContextPath()%>/InsertUser" method="post" class="h-adr" name="signUpForm">
 			<input type="hidden" name="" value="Japan" class="p-country-name">
 			<p>会員情報</p>
 			<table>
 				<tr>
 					<td><span class="err-msg-user-name"></span></td>
 					<td><span class="err-msg-email"></span></td>
 					<td><span class="err-msg-password"></span></td>
 					<td><span class="err-msg-again-password"></span></td>
 				</tr>
 				<tr>
 					<td><input type="text" name="user-name" id="user-name" placeholder="ユーザー名" required></td>
 					<td><input type="email" name="email" id="email" placeholder="メールアドレス" required></td>
 					<td><input type="password" name="password" id="password" placeholder="パスワード(5文字以上の英数字)" required></td>
 					<td><input type="password" name="again-password" id="again-password" placeholder="パスワード(確認用)" required></td>
 				</tr>
 			</table>



 			<p>個人情報</p>
 			<table>
 				<tr>
 					<td><span class="err-msg-family-name"></span></td>
 					<td><span class="err-msg-given-name"></span></td>
 					<td></td>
 				</tr>
 				<tr>
 					<td><input type="text" name="family-name" id="family-name" placeholder="苗字" required></td>
 					<td><input type="text" name="first-name" id="given-name" placeholder="名前" required></td>
 					<td><select name="gender" id="">
 						<option value="1">1.男性</option>
 						<option value="2">2.女性</option>
 						<option value="3">3.その他</option>
 						</select>
 					</td>
 				</tr>
 			</table>
 			<table>
 				<tr>
 					<td><span class="err-msg-birthday"></span></td>
 					<td><span class="err-msg-tel"></span></td>
 				</tr>
 				<tr>
 					<td><span>生年月日</span>
 			<input type="date" name="birthday" id="birthday" max="<%=format.format(date) %>" required></td>
 			<td><input type="tel" name="phone-number" id="tel" placeholder="電話番号" min="0" required></td>
 				</tr>
 			</table>



 			<br>

 			<br>

 			<p>住所</p>
 			<table>
 				<tr>
 					<td><span class="err-msg-postal-code"></span></td>
 				</tr>
 				<tr>
 					<td><input type="number" name="postal-code" id="postal-code" placeholder="郵便番号" class="p-postal-code" maxlength="7" required></td>
 				</tr>
 			</table>
 			<select name="prefecture-id" id="">
 				<option value="1">1.北海道</option>
 				<option value="2">2.青森県</option>
 				<option value="3">3.岩手県</option>
 				<option value="4">4.宮城県</option>
 				<option value="5">5.秋田県</option>
 				<option value="6">6.山形県</option>
 				<option value="7">7.福島県</option>
 				<option value="8">8.茨城県</option>
 				<option value="9">9.栃木県</option>
 				<option value="10">10.群馬県</option>
 				<option value="11">11.埼玉県</option>
 				<option value="12">12.千葉県</option>
 				<option value="13">13.東京都</option>
 				<option value="14">14.神奈川県</option>
 				<option value="15">15.新潟県</option>
 				<option value="16">16.富山県</option>
 				<option value="17">17.石川県</option>
 				<option value="18">18.福井県</option>
 				<option value="19">19.山梨県</option>
 				<option value="20">20.長野県</option>
 				<option value="21">21.岐阜県</option>
 				<option value="22">22.静岡県</option>
 				<option value="23">23.愛知県</option>
 				<option value="24">24.三重県</option>
 				<option value="25">25.滋賀県</option>
 				<option value="26">26.京都府</option>
 				<option value="27">27.大阪府</option>
 				<option value="28">28.兵庫県</option>
 				<option value="29">29.奈良県</option>
 				<option value="30">30.和歌山県</option>
 				<option value="31">31.鳥取県</option>
 				<option value="32">32.島根県</option>
 				<option value="33">33.岡山県</option>
 				<option value="34">34.広島県</option>
 				<option value="35">35.山口県</option>
 				<option value="36">36.徳島県</option>
 				<option value="37">37.香川県</option>
 				<option value="38">38.愛媛県</option>
 				<option value="39">39.高知県</option>
 				<option value="40">40.福岡県</option>
 				<option value="41">41.佐賀県</option>
 				<option value="42">42.長崎県</option>
 				<option value="43">43.熊本県</option>
 				<option value="44">44.大分県</option>
 				<option value="45">45.宮崎県</option>
 				<option value="46">46.鹿児島県</option>
 				<option value="47">47.沖縄県</option>
 			</select>
 			<br>
 			<table>
 				<tr>
 					<td><span class="err-msg-address1"></span></td>
 				</tr>
 				<tr>
 					<td><input type="text" name="address1" id="address1" placeholder="市区町村" class="address1" required></td>
 				</tr>
 			</table>

 			<br>
 			<input type="text" name="address2" id="" placeholder="建物名・部屋番号" class="address2">
 			<br>
 				<input type="hidden" name="authority" value="1">
 			<br>
 			<input type="submit" value="登録" class="submit">

 		</form>
 		</div>
 	</div>
 </body>
 </html>
