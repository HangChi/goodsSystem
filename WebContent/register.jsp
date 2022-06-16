<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>注册界面</title>
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
				<h3>欢迎注册</h3>
				<span>已有帐号？</span> <a href="login.jsp" style="color:red">登录</a>
				<form action="/goodsSystem/register.do" name="f" method="post">
					<div class="input_outer">
						<span class="u_user"></span>
						<input name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户名">
						<div id="username_err" class="err_msg" style="color: red">${register_msg}</div>
					</div>
					<div class="input_outer">
						<span class="us_uer"></span>
						<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
					</div>
					<div class="mb2"><input class="act-but submit" type="submit" style="color: #FFFFFF" value="注册"></div>
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