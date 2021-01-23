<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>职位管理页面</title>
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
                        <li><a href="#">职位管理</a></li>
                        <li class="active">职位信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="job_table">
                    <thead>
                    <th>职位ID</th>
                    <th>职位编号</th>
                    <th>职位名称</th>
                    <th>所属部门</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${jobs}" var="job">
                            <tr>
                            	<td>${job.id}</td>
                                <td>${job.jobno}</td>
                                <td>${job.jobname}</td>
                                <td>${job.dept.deptname}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary job_edit_btn" data-toggle="modal" data-target=".job-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger job_delete_btn">删除</a>
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
                            <li><a href="${pageContext.request.contextPath}/job/getJobList?pageNo=1">首页</a></li>
                            <c:if test="${curPageNo==1}">
                                <li class="disabled">
                                    <a href="${pageContext.request.contextPath}/job/getJobList?pageNo=1" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPageNo!=1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/job/getJobList?pageNo=${curPageNo-1}" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${totalPages<5?totalPages:5}" step="1" var="itemPage">
                                <c:if test="${curPageNo == itemPage}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/job/getJobList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPageNo != itemPage}">
                                    <li><a href="${pageContext.request.contextPath}/job/getJobList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${curPageNo==totalPages}">
                                <li class="disabled" class="nextPage">
                                    <a href="${pageContext.request.contextPath}/job/getJobList?pageNo=${totalPages}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${curPageNo!=totalPages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/job/getJobList?pageNo=${curPageNo+1}" aria-label="Next" class="nextPage">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath}/job/getJobList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="jobAdd.jsp"%>
<%@ include file="jobUpdate.jsp"%>


<script>
/*     $(function () {
        //上一页
        var curPage = ${curPageNo};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "${pageContext.request.contextPath}/job/getJobList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "${pageContext.request.contextPath}/job/getJobList?pageNo="+pageNo);
            }
        });
    }); */

    $(".job_delete_btn").click(function () {
        var curPage = ${curPageNo};
        var id = $(this).parent().parent().find("td:eq(0)").text();
        var delJobName = $(this).parent().parent().find("td:eq(2)").text();
        if (confirm("确认删除【" + delJobName+ "】？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/job/deleteJob/"+id,
                type:"Get",
                data:{"id":id},
                success:function (data) {
                	alert("删除成功！");
                	window.location.href="${pageContext.request.contextPath}/job/getJobList?pageNo="+curPage;
                },error:function(){
                	alert("删除失败！");
                }
                        
            });
        }
    });


</script>
</body>
</html>
