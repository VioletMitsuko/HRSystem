<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>公告管理页面</title>
</head>
<body>
<div class="hrms_container">
    <!-- 导航条 -->
    <%@ include file="./commom/head.jsp"%>

    <!-- 中间部分（包括左边栏和员工/部门表单显示部分） -->
    <div class="hrms_body" style="position:relative; top:-15px;">

        <!-- 左侧栏 -->
        <%@ include file="./commom/leftsidebar.jsp"%>

        <!-- 中间员工表格信息展示内容 -->
        <div class="emp_info col-sm-10">

            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div class="panel-heading">
                    <ol class="breadcrumb">
                        <li><a href="#">公告管理</a></li>
                        <li class="active">公告信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="notice_table">
                    <thead>
                    <th>公告ID</th>
                    <th>公告标题</th>
                    <th>公告内容</th>
                    <th>发布日期</th>
                    <th>修改日期</th>
                    <th>发布人</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${notices}" var="notice">
                            <tr>
                            	<td>${notice.id}</td>
                                <td>${notice.title}</td>
                                <td>${notice.context}</td>
                                <td><fmt:formatDate value="${notice.create_date}" dateStyle="medium"/></td>
                                <td><fmt:formatDate value="${notice.lastModifiled}" dateStyle="medium"/></td>
                                <td>${notice.user.username}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary notice_edit_btn" data-toggle="modal" data-target=".notice-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger notice_delete_btn">删除</a>
                                    <a href="#" role="button" class="btn btn-primary notice_show_btn">展示</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span class="badge">${curPageNo}</span>页，共有<span class="badge">${totalPages}</span>页，总记录数<span class="badge">${totalItems}</span>条。
                    </div>
                    <nav aria-label="Page navigation" class="pull-right">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/notice/getNoticeList?pageNo=1">首页</a></li>
                            <c:if test="${curPageNo==1}">
                                <li class="disabled">
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPageNo!=1}">
                                <li>
                                    <a href="#" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${totalPages<5?totalPages:5}" step="1" var="itemPage">
                                <c:if test="${curPageNo == itemPages}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/notice/getNoticeList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPageNo != itemPages}">
                                    <li><a href="${pageContext.request.contextPath}/notice/getNoticeList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${curPageNo==totalPages}">
                                <li class="disabled" class="nextPage">
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPageNo!=totalPages}">
                                <li>
                                    <a href="#" aria-label="Next" class="nextPage">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath}/notice/getNoticeList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="noticeAdd.jsp"%>
<%@ include file="noticeUpdate.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPageNo};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "${pageContext.request.contextPath}/notice/getNoticeList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "${pageContext.request.contextPath}/notice/getNoticeList?pageNo="+pageNo);
            }
        });
    });

    $(".notice_delete_btn").click(function () {
        var id = $(this).parent().parent().find("td:eq(0)").text();
        var delNoticeName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delNoticeName+ "】？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/notice/deleteNotice/"+id,
                type:"Get",
                data:{"id":id},
                success:function (data) {
                	alert("删除成功！");
                	window.location.href="${pageContext.request.contextPath}/notice/getNoticeList?pageNo="+curPage;
                },error:function(){
                	alert("删除失败！");
                }
                        
            });
        }
    });
    
    $(".notice_show_btn").click(function () {
        var id = $(this).parent().parent().find("td:eq(0)").text();
        var delNoticeName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认展示【" + delNoticeName+ "】？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/user/showNotice/"+id,
                type:"Get",
                data:{"id":id},
                success:function (data) {
                	alert("展示成功！");
                	window.location.href="${pageContext.request.contextPath}/user/main";
                },error:function(){
                	alert("展示失败！");
                }
                        
            });
        }
    });


</script>
</body>
</html>
