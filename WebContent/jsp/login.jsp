<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>用户登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
		
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
   		 <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</head>
	<body>
		<div class="login">			
			<h2>用户登录</h2>
			<div class="login_box">
				<!-- required就是不能为空 必须在css效果中有很大的作用 -->
				<!-- 可以简写为required -->
				<input type="text" id="username" name="username" required /><label>用户名</label>
			</div>
			<div class="login_box">
				<input type="password" id="password" name="password" required="required" /><label>密码</label>
			</div>
			<a href="javascript:void(0)">
				登录
				<span></span>
				<span></span>
				<span></span>
				<span></span>
			</a>
			
		</div>
		
		
		<script type="text/javascript">
			if(${not empty message}){
				alert("${message}");
			}	
		
			$("a").click(function(){
				var username = $("#username").val();
				
				var password = $("#password").val();
				
				$.ajax({
		            url:"${pageContext.request.contextPath}/user/login",
		            type:"GET",
		            data:{"username":username,"password":password},
		            contentType:"application/json;charset=UTF-8",
		            success:function(data) {
		            	if(data != null && data !=""){
		            		window.location.href="${pageContext.request.contextPath}/jsp/main.jsp";
		            	}else{
		            		alert("登陆失败，用户名或密码错误！")
		            	}
		            },error:function(){
		                alert("出现错误！");
		           		}
		        });
				
			});
			
		
		</script>
	</body>
</html>
