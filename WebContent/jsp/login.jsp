<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>用户登录</title>
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<div class="login">
			<h2>用户登录</h2>
			<div class="login_box">
				<!-- required就是不能为空 必须在css效果中有很大的作用 -->
				<!-- 可以简写为required -->
				<input type="text" name="username" required="required" /><label>用户名</label>
			</div>
			<div class="login_box">
				<input type="password" name="password" required="required" /><label>密码</label>
			</div>
			<a href="user/login">
				登录
				<span></span>
				<span></span>
				<span></span>
				<span></span>
			</a>
		</div>
	</body>
</html>
