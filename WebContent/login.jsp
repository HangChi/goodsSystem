<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />

</head>
<body>
	<div class="container demo-1">
	<div class="content">
		<div id="large-header" class="large-header">
			<canvas id="demo-canvas"></canvas>
			<div class="logo_box">
				<h3>欢迎登录</h3>
				<form action="/goodsSystem/login.do" name="f" method="post">
				<div id="errorMsg" style="color: red">${logout_msg} ${login_msg} ${register_msg}</div>
					<div class="input_outer">
						<span class="u_user"></span>
						<input name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户名" value="${cookie.name.value}">
					</div>
					<div class="input_outer">
						<span class="us_uer"></span>
						<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" type="password" placeholder="请输入密码" value="${cookie.password.value}">
					</div>
					<p>记住我:<input id="remember" name="remember" value="1" type="checkbox"></p>
					<a href="register.jsp" style="color:red">没有账号？</a>
					<div class="mb2"><input class="act-but submit" type="submit" style="color: #FFFFFF" value="登录"></div>
					
				</form>
			</div>
		</div>
	</div>
	</div><!-- /container -->
	<script src="js/TweenLite.min.js"></script>
	<script src="js/EasePack.min.js"></script>
	<script src="js/rAF.js"></script>
	<script src="js/demo-1.js"></script>
</body>
</html>