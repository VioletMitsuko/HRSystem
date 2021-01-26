<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>部门新增页面</title>
</head>
<body>
<div class="modal fade dept-add-modal" tabindex="-1" role="dialog" aria-labelledby="dept-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">部门新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_dept_form">
                	<div class="form-group">
                        <label for="add_deptName" class="col-sm-2 control-label">部门编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="deptno" class="form-control" id="add_deptno" placeholder="编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_deptName" class="col-sm-2 control-label">部门名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="deptname" class="form-control" id="add_deptName" placeholder="人事部">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_create_date" class="col-sm-2 control-label">创建日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="create_date" class="form-control" id="add_create_date">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_deptLeader" class="col-sm-2 control-label">部门主管</label>
                        <div class="col-sm-8">
                            <input type="text" name="deptManager" class="form-control" id="add_deptLeader" placeholder="员工ID">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary dept_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
    $(".dept_add_btn").click(function () {
        $('.dept-add-modal').modal({
            backdrop:static,
            keyboard:true
        });

    });

    $(".dept_save_btn").click(function () {
    	var deptno = $("#add_deptno").val();
        var deptname = $("#add_deptName").val();
        var create_date = $("#add_create_date").val();
        var deptManager =  $("#add_deptLeader").val();
        $.ajax({
            url:"${pageContext.request.contextPath}/dept/addDept",
            type:"GET",
            data:{"deptno":deptno,"deptname":deptname,"create_date":create_date,"deptManager":deptManager},
            success:function (data) {
                    alert("添加成功");
                    $('.dept-add-modal').modal("hide");
                    $.ajax({
                        url:"${pageContext.request.contextPath}/dept/getTotalPages",
                        type:"GET",
                        success:function (data) {
                           var totalPage = data;
                           window.location.href="${pageContext.request.contextPath}/dept/getDeptList?pageNo="+totalPage;
                        }
                    }); 
                },error:function(){
                	alert("添加失败");
                }
            });
        });
</script>
</body>
</html>
