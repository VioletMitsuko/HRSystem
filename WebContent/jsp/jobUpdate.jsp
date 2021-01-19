<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门更改页面</title>
</head>
<body>
<div class="modal fade job-update-modal" tabindex="-1" role="dialog" aria-labelledby="job-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">职位更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_job_form">
                    <div class="form-group">
                        <label for="update_jobno" class="col-sm-2 control-label">职位编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="jobno" class="form-control" id="update_jobno" placeholder="编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_jobname" class="col-sm-2 control-label">职位名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="jobname" class="form-control" id="update_jobname" placeholder="名称">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="update_dept_id" class="col-sm-2 control-label">所属部门</label>
                        <div class="col-sm-8">
                            <input type="text" name="dept_id" class="form-control" id="update_dept_id" placeholder="所属部门ID">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary job_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
     $(".job_edit_btn").click(function () {
        id = $(this).parent().parent().find("td:eq(0)").text();
    }); 

    $(".job_update_btn").click(function () {
        var jobno = $("#update_jobno").val();
        var jobname = $("#update_jobname").val();
        var dept_id = $("#update_dept_id").val();
        var curPageNo = ${curPageNo};
        $.ajax({
            url:"${pageContext.request.contextPath}/job/updateJob/"+id,
            type:"GET",
            data:{"jobno":jobno,"jobname":jobname,"dept_id":dept_id,"id":id},
            success:function (data) {
                    alert("更新成功！");
                    window.location.href = "${pageContext.request.contextPath}/job/getJobList?pageNo="+curPageNo;              
            },error:function(){
            	alert("更新失败");
            }
        });
    });
</script>
</body>
</html>
