 <%@page contentType="text/html;charset=UTF-8"%>

 <html lang="ja">
 <head>
 	<meta charset="UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="css/menu.css">
 	<link rel="stylesheet" href="css/style.css">
 	<script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
 	<title>神田雑貨店フリマ -会員登録-</title>
 </head>
 <body>
 	<header>
 		<nav class="nav-normal">
 			<ul>
 				<li class="logo">神田雑貨店</li>
 				<li><a href="index.html">HOME</a></li>
 				<li><a href="#">商品一覧</a></li>
 				<li><input type="text" name="" id="" class="search" placeholder="なにをお探しですか？"><input type="button" value="🔍" class="search"></li>
 				<li><div class="spacer"></div></li>
 				<li><a href="#">会員登録</a></li>
 				<li><a href="#">ログイン</a></li>
 			</ul>
 		</nav>
 	</header>

 	<div class="container">
 		<div class="signup-form">
 			<h1>会員登録</h1>
 		<form action="<%=request.getContextPath()%>/InsertUser" method="post" class="h-adr">
 			<input type="hidden" name="" value="Japan" class="p-country-name">
 			<p>会員情報</p>
 			<input type="text" name="user-name" id="" placeholder="ユーザー名" required>
 			<input type="email" name="email" id="" placeholder="メールアドレス" required>
 			<input type="password" name="password" id="" placeholder="パスワード" required>
 			<input type="password" name="again-password" id="" placeholder="パスワード(確認用)" required>
 			<p>個人情報</p>
 			<input type="text" name="family-name" id="" placeholder="苗字" required>
 			<input type="text" name="first-name" id="" placeholder="名前" required>
 			<select name="gender" id="">
 				<option value="1">1.男性</option>
 				<option value="2">2.女性</option>
 				<option value="3">3.その他</option>
 			</select>
 			<br>
 			<span>生年月日</span>
 			<input type="date" name="birthday" id="" required>
 			<br>
 			<input type="tel" name="phone-number" id="" placeholder="電話番号" min="0" required>
 			<p>住所</p>
 			<input type="number" name="postal-code" id="" placeholder="郵便番号" class="p-postal-code" maxlength="8" required>
 			<br>
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
 			<input type="text" name="address1" id="" placeholder="住所1" class="address1" required>
 			<br>
 			<input type="text" name="address2" id="" placeholder="住所2" class="address2" required>
 			<br>
 			<select name="authority">
 				<option value="1">1.一般ユーザー</option>
 				<option value="2">2.管理者</option>
 			</select>
 			<br>
 			<input type="submit" value="登録">

 		</form>
 		</div>
 	</div>
 </body>
 </html>