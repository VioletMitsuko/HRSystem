<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="panel-group col-sm-2" id="hrms_sidebar_left" role="tablist" aria-multiselectable="true">
    <ul class="nav nav-pills nav-stacked emp_sidebar">
        <li role="presentation" class="active">
            <a href="#" data-toggle="collapse" data-target="#collapse_emp">
                <span class="glyphicon glyphicon-user" aria-hidden="true">员工管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_emp">
                <li role="presentation"><a href="#" class="emp_info">员工列表</a></li>
                <li role="presentation"><a href="#" role="button" class="emp_add_btn" data-toggle="modal" data-target=".emp-add-modal">员工新增</a></li>
            </ul>
        </li>
    </ul>
        <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">合同管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="contract_info">合同列表</a></li>
                <li role="presentation"><a href="#" class="contract_add_btn" data-toggle="modal" data-target=".contract-add-modal">合同新增</a></li>
            </ul>
        </li>
    </ul>  
    <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">部门管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="dept_info">部门列表</a></li>
                <li role="presentation"><a href="#" class="dept_add_btn" data-toggle="modal" data-target=".dept-add-modal">部门新增</a></li>
            </ul>
        </li>
    </ul>
        <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">职位管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="job_info">职位列表</a></li>
                <li role="presentation"><a href="#" class="job_add_btn" data-toggle="modal" data-target=".job-add-modal">职位新增</a></li>
            </ul>
        </li>
    </ul>
            <ul class="nav nav-pills nav-stacked dept_sidebar">
        <li role="presentation" class="active">
            <a href="#"  data-toggle="collapse" data-target="#collapse_dept">
                <span class="glyphicon glyphicon-cloud" aria-hidden="true">公告管理</span>
            </a>
            <ul class="nav nav-pills nav-stacked" id="collapse_dept">
                <li role="presentation"><a href="#" class="notice_info">公告列表</a></li>
                <li role="presentation"><a href="#" class="notice_add_btn" data-toggle="modal" data-target=".notice-add-modal">公告新增</a></li>
            </ul>
        </li>
    </ul>

</div><!-- /.panel-group，#hrms_sidebar_left -->

<script type="text/javascript">
    //跳转到员工页面
    $(".emp_info").click(function () {
        $(this).attr("href", "${pageContext.request.contextPath}/employee/findAll");
    });
    //跳转到合同页面
    $(".contract_info").click(function () {
        $(this).attr("href", "${pageContext.request.contextPath}/contract/getContractList");
    });
    //跳转到部门页面
    $(".dept_info").click(function () {
        $(this).attr("href", "${pageContext.request.contextPath}/dept/findAll");
    });
  //跳转到职位页面
    $(".job_info").click(function () {
        $(this).attr("href", "${pageContext.request.contextPath}/job/getJobList");
    });
    //跳转到公告页面
    $(".notice_info").click(function () {
        $(this).attr("href", "${pageContext.request.contextPath}/notice/getNoticeList");
    });
</script>
</body>
</html>
