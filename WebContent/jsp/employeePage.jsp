<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工管理页面</title>
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
                        <li><a href="#">员工管理</a></li>
                        <li class="active">员工信息</li>
                    </ol>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover" id="emp_table">
                    <thead>
                    <th>员工编号</th>
                    <th>员工姓名</th>
                    <th>员工工号</th>
                    <th>性别</th>
                    <th>部门</th>
                    <th>职位</th>
                    <th>操作</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${pageBean.list}" var="employee">
                            <tr>
                                <td>${employee.empID}</td>
                                <td>${employee.empname}</td>
                                <td>${employee.jobnum}</td>
                               	<td>${employee.gender eq 0 ? '男':'女'}</td>                                                                         
                                <td>${employee.dept.deptname }</td>
                                <td>${employee.job.jobname}</td>
                                <td>
                                    <a href="#" role="button" class="btn btn-primary emp_edit_btn" data-toggle="modal" data-target=".emp-update-modal">编辑</a>
                                    <a href="#" role="button" class="btn btn-danger emp_delete_btn">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                     
                    </tbody>
                </table>

                <div class="panel-body">
                    <div class="table_items">
                        当前第<span class="badge">${pageBean.curPage}</span>页，共有<span class="badge">${pageBean.totalPages}</span>页，总记录数<span class="badge">${pageBean.totalItems}</span>条。
                    </div>
                    <nav aria-label="Page navigation" class="pull-right">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=1">首页</a></li>
                            <c:if test="${pageBean.curPage==1}">
                                <li class="disabled">
                                    <a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=1" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>
                        
                            <c:if test="${pageBean.curPage!=1}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=${pageBean.curPage-1}" aria-label="Previous" class="prePage">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${pageBean.totalPages<5?pageBean.totalPages:5}" step="1" var="itemPage">
                                <c:if test="${pageBean.curPage == itemPage}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                                <c:if test="${pageBean.curPage != itemPage}">
                                    <li><a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=${itemPage}">${itemPage}</a></li>
                                </c:if>
                            </c:forEach>

                            <c:if test="${pageBean.curPage==pageBean.totalPages}">
                                <li class="disabled" class="nextPage">
                                    <a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=${pageBean.totalPages}" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pageBean.curPage!=pageBean.totalPages}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=${pageBean.curPage+1}" aria-label="Next" class="nextPage">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>
                            <li><a href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo=${pageBean.totalPages}">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div><!-- /.panel panel-success -->
        </div><!-- /.emp_info -->

        <!-- 尾部 -->
      <%--  <%@ include file="./commom/foot.jsp"%>--%>
    </div><!-- /.hrms_body -->
</div><!-- /.container -->

<%@ include file="employeeAdd.jsp"%>
<%@ include file="employeeUpdate.jsp"%>


<script>

   /*  $(function () {
        //上一页
        var curPage = ${curPage};
        var totalPages = ${totalPages};
        $(".prePage").click(function () {
            if (curPage > 1){
                var pageNo = curPage-1;
                $(this).attr("href", "/hrms/emp/getEmpList?pageNo="+pageNo);
            }
        });
        //下一页
        $(".nextPage").click(function () {
            if (curPage < totalPages){
                var pageNo = curPage+1;
                $(this).attr("href", "/hrms/emp/getEmpList?pageNo="+pageNo);
            }
        });
    }) */

   
    $(".emp_delete_btn").click(function () {
        var curPage = ${pageBean.curPage};
        var delEmpId = $(this).parent().parent().find("td:eq(0)").text();
        var delEmpName = $(this).parent().parent().find("td:eq(1)").text();
        if (confirm("确认删除【" + delEmpName+ "】的信息吗？")){
            $.ajax({
                url:"${pageContext.request.contextPath}/employee/deleteEmp?empID="+delEmpId,
                type:"GET",
                success:function() {                   
                    alert("删除成功！");
                    window.location.href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo="+curPage;                                      
                },error:function(){
                	alert("删除失败！");
                }
            });
        }
    });


</script>
</body>
</html>
