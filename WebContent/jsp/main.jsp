<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>人力资源系统后台</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <div class="hrms_main_ad col-sm-10">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 style="text-align: center;">欢迎进入人力资源管理系统！</h3>
                </div>
                <div class="panel-body" style="position:relative; top:-15px;">
                	<h2>公告：</h2><br>
                	<div class="panel-body" style="position:relative; top:-15px;">
                		<h3 align="center">${notice.title}</h3><br>
                        <div style="margin: auto 100px">${notice.context}</div>
                        <div align="right">
                        	<fmt:formatDate value="${notice.create_date}" dateStyle="medium"/>
                        </div>
                	</div>
                </div><!-- /.panel-body -->
            </div><!-- /.panel -->
        </div><!-- /.hrms_main_ad -->
    </div><!-- /.hrms_body -->
    <!-- 尾部 -->
    <%-- <%@ include file="./commom/foot.jsp"%>--%>
</div><!-- /.hrms_container -->

</body>
</html>
