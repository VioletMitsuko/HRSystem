<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Employee Update Page</title>
</head>
<body>
<div class="modal fade emp-update-modal" tabindex="-1" role="dialog" aria-labelledby="emp-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">员工更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_emp_form">
                     <div class="form-group">
                        <label for="update_empID" class="col-sm-2 control-label">员工编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="empID" class="form-control" id="update_empID" readonly="readonly">                     
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_empName" class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="empname" class="form-control" id="update_empName">                     
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_empJobNum" class="col-sm-2 control-label">员工工号</label>
                        <div class="col-sm-8">
                            <input type="text" name="jobnum" class="form-control" id="update_empJobNum">                     
                        </div>
                    </div>
                  
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="update_empGender1" value="0"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="update_empGender2" value="1"> 女
                            </label>
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <label for="update_department" class="col-sm-2 control-label">部门</label>
                        <div class="col-sm-8">
                            <input type="text" name="dept_id" class="form-control" value="" id="update_department">                     
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="update_JobId" class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-8">
                            <input type="text" name="job_id" class="form-control" value="" id="update_JobId">                     
                        </div>
                    </div>
                    
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary emp_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<script type="text/javascript">
    <!-- ==========================员工修改操作=================================== -->
    $(".emp_edit_btn").click(function () {
    	
        //1 获取点击修改员工的id与name;
        var updateEmpId = $(this).parent().parent().find("td:eq(0)").text();
		
        //2 根据id或name查询出对应员工信息进行回显；
        $.ajax({
            url:"${pageContext.request.contextPath}/employee/findEmpByEmpID?empID="+updateEmpId,
            type:"GET",
            success:function (data) {                            
                $("#update_empID").val(data.empID);
               	$("#update_empName").val(data.empname);
                $("#update_empJobNum").val(data.jobnum);
                
                if(data.gender==1){
                	$("#update_empGender2").attr('checked',true);
                }else{
                	$("#update_empGender1").attr('checked',true);
                }
                $("#update_department").val(data.dept_id);
                $("#update_JobId").val(data.job_id);              
            }

        });
	
        //2 部门回显列表；
       /*  $.ajax({
            url:"/hrms/dept/getDeptName",
            type:"GET",
            success:function (result) {
                if (result.code == 100){
                    $.each(result.extendInfo.departmentList, function () {
                        var optEle = $("<option></option>").append(this.deptName).attr("value", this.deptId);
                        optEle.appendTo("#update_department");
                    });
                }
            }

        });

        $(".emp_update_btn").attr("updateEmpId", updateEmpId); */
    });


    $(".emp_update_btn").click(function () {
        //拿到修改之后的参数的值        
        var empID = $("#update_empID").val();
		var empname = $("#update_empName").val();
		var jobnum = $("#update_empJobNum").val();
		var gender = $("input[type='radio']:checked").val();
		var dept_id = $("#update_department").val();
		var job_id = $("#update_JobId").val();
		
		
        /*   //4 进行修改，对修改的邮箱格式进行判断；
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        var updateEmpEamil = $("#update_empEmail").val();
        if (!regEmail.test(updateEmpEamil)){
            $("#update_empEmail").parent().parent().removeClass("has-sucess");
            $("#update_empEmail").parent().parent().addClass("has-error");
            $("#helpBlock_update_inputEmail").text("邮箱格式不正确！");
            return false;
        }else {
            $("#update_empEmail").parent().parent().removeClass("has-error");
            $("#update_empEmail").parent().parent().addClass("has-success");
            $("#helpBlock_update_inputEmail").text("");
        }
 */
        //5 点击更新按钮，发送AJAX请求到后台进行保存。
        $.ajax({
            url:"${pageContext.request.contextPath}/employee/updateEmp",
            type:"GET",
            data:{"empID":empID,"empname":empname,"jobnum":jobnum,"gender":gender,"dept_id":dept_id,"job_id":job_id},
            success:function (result) {
               
                alert("员工更改成功！");
                $(".emp-update-modal").modal("hide");
                    //跳转到当前页
                var curPage = ${pageBean.curPage};
                window.location.href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo="+curPage;               
            }
        });

    });
</script>
</body>
</html>
