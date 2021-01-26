<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门更改页面</title>
</head>
<body>
<div class="modal fade dept-update-modal" tabindex="-1" role="dialog" aria-labelledby="dept-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">部门更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_dept_form">
                    <div class="form-group">
                        <label for="update_deptno" class="col-sm-2 control-label">部门编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="deptno" class="form-control" id="update_deptno">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_deptName" class="col-sm-2 control-label">部门名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="deptname" class="form-control" id="update_deptName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_create_date" class="col-sm-2 control-label">创建日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="create_date" class="form-control" id="update_create_date">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_deptLeader" class="col-sm-2 control-label">部门主管</label>
                        <div class="col-sm-8">
                            <input type="text" name="deptLeader" class="form-control" id="update_deptLeader">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary dept_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
    var curPageNo = ${curPageNo};

    $(".dept_edit_btn").click(function () {
        id = $(this).parent().parent().find("td:eq(0)").text();
        $.ajax({
            url:"${pageContext.request.contextPath}/dept/findDeptById?id="+id,
            type:"GET",
            success:function (data) {
            	$("#update_deptno").val(data.deptno);
                $("#update_deptName").val(data.deptname);
                $("#update_create_date").val(data.create_date);
                $("#update_deptLeader").val(data.deptManager);
            }
        });
    });

    $(".dept_update_btn").click(function () {
    	var deptno = $("#update_deptno").val();
       var deptname = $("#update_deptName").val();
       var create_date = $("#update_create_date").val();
       var deptManager =  $("#update_deptLeader").val();
    	var curPageNo = ${curPageNo};
        $.ajax({
            url:"${pageContext.request.contextPath}/dept/updateDept/"+id,
            type:"GET",
            data:{"deptno":deptno,"deptname":deptname,"create_date":create_date,"deptManager":deptManager,"id":id},
            success:function (date) {
                    alert("更新成功！");
                    window.location.href = "${pageContext.request.contextPath}/dept/getDeptList?pageNo="+curPageNo;
            },error:function(){
            	alert("更新失败");
            }
        });
    });


</script>
</body>
</html>
