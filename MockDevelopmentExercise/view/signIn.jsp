<%@page contentType="text/html;charset=UTF-8"%>


<html lang ="ja">
    <head>
        <title>神田雑貨店フリマ</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/menu.css">
    <link rel="stylesheet" href="css/style.css">
        </head>
        <body>
         <header>
	        <nav class="nav-normal">
	            <ul>
	                <li class="logo">神田雑貨店</li>
	                <li><a href="#">トップページ</a></li>
	                <li><a href="#">商品一覧</a></li>
	                <li><input type="text" name="" id="" class="search" placeholder="なにをお探しですか？"><input type="button" value="🔍" class="search"></li>
	                <li><div class="spacer"></div></li>
	            </ul>
	    	</nav>
    	</header>
        <div class="container">
        	<h2 align="center">ログイン</h2>

            <form action="<%=request.getContextPath()%>/SignInServlet" method="post">
                <table align = "center">
                    <tr>
                        <td>メールアドレス</td>
                        <td><input type=text size="20" name="mail"></td> <!--メールアドレス入力-->
                    </tr>
                    <tr>
                        <td>パスワード</td>
                        <td><input type=password size="20" name="password"></td> <!--password入力-->
                </table>
                <p align="center"><input type="submit" value="ログイン"></p>
            </form>
        </div>
        </body>
</html>