<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>职位新增页面</title>
</head>
<body>
<div class="modal fade job-add-modal" tabindex="-1" role="dialog" aria-labelledby="job-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">职位新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_job_form">
                     <div class="form-group">
                        <label for="add_jobno" class="col-sm-2 control-label">职位编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="jobno" class="form-control" id="add_jobno" placeholder="编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_jobname" class="col-sm-2 control-label">职位名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="jobname" class="form-control" id="add_jobname" placeholder="人事部">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="add_dept_id" class="col-sm-2 control-label">所属部门</label>
                        <div class="col-sm-8">
                            <input type="text" name="dept_id" class="form-control" id="add_dept_id" placeholder="所属部门ID">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary job_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
     $(".job_add_btn").click(function () {
        $('.job-add-modal').modal({
            backdrop:static,
            keyboard:true
        });

    }); 

    $(".job_save_btn").click(function () {
        var jobno = $("#add_jobno").val();
        var jobname = $("#add_jobname").val();
        var dept_id = $("#add_dept_id").val();
        //验证省略...
        $.ajax({
            url:"${pageContext.request.contextPath}/job/addJob",
            type:"GET",
            data:{"jobno":jobno,"jobname":jobname,"dept_id":dept_id},
            success:function (data) {
                    alert("添加成功");
                    $('.job-add-modal').modal("hide");
                    $.ajax({
                        url:"${pageContext.request.contextPath}/job/getTotalPages",
                        type:"GET",
                        success:function () {
                           var totalPage = ${totalPages};
                           window.location.href="${pageContext.request.contextPath}/job/getJobList?pageNo="+totalPage;
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
