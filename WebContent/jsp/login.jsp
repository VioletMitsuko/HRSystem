<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>用户登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	</head>
	<body>
	<form role="form" action="${pageContext.request.contextPath}/user/login" method="post" id="login_form" name="form1">
		<div class="login">
			<h2>用户登录</h2>
			<div class="login_box">
				<input type="text" name="username" required="required" id=username /><label>用户名</label>
			</div>
			<div class="login_box">
				<input type="password" name="password" required="required" id=password /><label>密码</label>
			</div>
			<a href='javascript:document.form1.submit();' id="login_btn">
				登录
				<span></span>
				<span></span>
				<span></span>
				<span></span>
			</a>
			
		</div>
	</form>

	</body>
</html>
