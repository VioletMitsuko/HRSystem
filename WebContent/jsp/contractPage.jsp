<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>合同管理页面</title>
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
                        <li><a href="#">合同管理</a></li>
                        <li class="active">合同信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="contract_table">
                    <thead>
                    <th>合同ID</th>
                    <th>签约日期</th>
                    <th>起始日期</th>
                    <th>结束日期</th>
                    <th>合同状态</th>
                    <th>签约人</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${contracts}" var="contract">
                            <tr>
                            	<td>${contract.id}</td>
                                <td><fmt:formatDate value="${contract.contract_date}" dateStyle="medium"/></td>
                                <td><fmt:formatDate value="${contract.start_date}" dateStyle="medium"/></td>
                                <td><fmt:formatDate value="${contract.end_date}" dateStyle="medium"/></td>
                                <td>${contract.comment}</td>
                                <td>${contract.emp.empname}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary contract_edit_btn" data-toggle="modal" data-target=".contract-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger contract_delete_btn">删除</a>
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
                            <li><a href="${pageContext.request.contextPath}/contract/getContractList?pageNo=1">首页</a></li>
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
                                <c:if test="${curPageNo == itemPage}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/contract/getContractList?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${curPageNo != itemPage}">
                                    <li><a href="${pageContext.request.contextPath}/contract/getContractList?pageNo=${itemPage}">${itemPage}</a></li>
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
                            <li><a href="${pageContext.request.contextPath}/contract/getContractList?pageNo=${totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
        <%@ include file="./commom/foot.jsp"%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="contractAdd.jsp"%>
<%@ include file="contractUpdate.jsp"%>


<script>
    $(function () {
        //上一页
        var curPage = ${curPageNo};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "${pageContext.request.contextPath}/contract/getContractList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "${pageContext.request.contextPath}/contract/getContractList?pageNo="+pageNo);
            }
        });
    });

    $(".contract_delete_btn").click(function () {
        var curPage = ${curPageNo};
        var id = $(this).parent().parent().find("td:eq(0)").text();
        var delcontractName = $(this).parent().parent().find("td:eq(2)").text();
        if (confirm("确认删除【" + delcontractName+ "】？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/contract/deleteContract/"+id,
                type:"Get",
                data:{"id":id},
                success:function (data) {
                	alert("删除成功！");
                	window.location.href="${pageContext.request.contextPath}/contract/getContractList?pageNo="+curPage;
                },error:function(){
                	alert("删除失败！");
                }
                        
            });
        }
    });


</script>
</body>
</html>
