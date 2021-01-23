<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Add Page</title>
</head>
<body>
<div class="modal fade emp-add-modal" tabindex="-1" role="dialog" aria-labelledby="emp-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">员工新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_emp_form">
                
                	<div class="form-group">
                        <label for="add_inputempID" class="col-sm-2 control-label">员工编号</label>
                        <div class="col-sm-8">
                            <input type="text" name="empID" class="form-control" id="add_inputempID" placeholder="如：421125198005113311">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="add_inputName" class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="empname" class="form-control" id="add_inputName" placeholder="如：张三">
                            <span id="helpBlock_add_inputName" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_inputJobNum" class="col-sm-2 control-label">员工工号</label>
                        <div class="col-sm-8">
                            <input type="text" name="jobnum" class="form-control" id="add_inputJobNum" placeholder="如：00001">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" checked="checked" name="gender" id="add_inputGender1" value="0"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="add_inputGender2" value="1"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_department" class="col-sm-2 control-label">部门</label>
                        <div class="col-sm-8">
                            <input type="text" name="dept_id" class="form-control" id="add_department" placeholder="如：1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_inputJobId" class="col-sm-2 control-label">职位</label>
                        <div class="col-sm-8">
                            <input type="text" name="job_id" class="form-control" id="add_inputJobId" placeholder="如：1">
                        </div>
                    </div>
                    
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary emp_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">

    <!-------------------------------------员工新增操作-------------------------------------->
    //=======0 点击 员工新增按钮，发送AJAX请求查询部门列表信息，弹出模态框，
    // 将查询得到的部门列表信息显示在对应模态框中部门信息处。=============================
    $(".emp_add_btn").click(function () {
       
    	/* $.ajax({
            url:"${pageContext.request.contextPath}/dept/findAll",
            type:"GET",
            success:function (result) {
               
                    $.each(result, function () {
                        var optionEle = $("<option></option>").append(this.deptname).attr("value", this.deptno);
                        optionEle.appendTo("#add_department");
                    });
               
            }
        }); */
		
        $('.emp-add-modal').modal({
            backdrop:static,
            keyboard:true
        });
    });
	
    //=========1 当鼠标从姓名输入框移开的时候，判断姓名输入框内的姓名是否重复 ============
   /*  $("#add_inputName").change(function () {
        var empName = $("#add_inputName").val();
        $.ajax({
            url:"/hrms/emp/checkEmpExists",
            type:"GET",
            data:"empName="+empName,
            success:function (result) {
                if (result.code == 100){
                    $("#add_inputName").parent().parent().removeClass("has-error");
                    $("#add_inputName").parent().parent().addClass("has-success");
                    $("#helpBlock_add_inputName").text("用户名可用！");
                    $(".emp_save_btn").attr("btn_name_exists", "success");
                }else {
                    $("#add_inputName").parent().parent().removeClass("has-success");
                    $("#add_inputName").parent().parent().addClass("has-error");
                    $("#helpBlock_add_inputName").text(result.extendInfo.name_reg_error);
                    $(".emp_save_btn").attr("btn_name_exists", "error");
                }
            }
        });
    }); */
	
    //3 保存

    $(".emp_save_btn").click(function() {
    	
		
        /* //1 获取到第3步：$(".emp_save_btn").attr("btn_name_exists", "success");中btn_name_exists的值
        // btn_name_exists = error，就是姓名重复
        if($(".emp_save_btn").attr("btn_name_exists") == "error"){
            return false;
        }
		
        //================2 对输入的姓名和邮箱格式进行验证===============
        var inputName = $("#add_inputName").val();
        var inputEmail = $("#add_inputEmail").val();
        //验证格式。姓名：2-5位中文或6-16位英文和数字组合；
        var regName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regName.test(inputName)){
            alert("测试：输入姓名格式不正确！");
            //输入框变红
            $("#add_inputName").parent().parent().addClass("has-error");
            //输入框下面显示红色提示信息
            $("#helpBlock_add_inputName").text("输入姓名为2-5位中文或6-16位英文和数字组合");
            return false;
        }else {
            //移除格式
            $("#add_inputName").parent().parent().removeClass("has-error");
            $("#add_inputName").parent().parent().addClass("has-success");
            $("#helpBlock_add_inputName").hide();
        }
        if (!regEmail.test(inputEmail)){
            //输入框变红
            $("#add_inputEmail").parent().parent().addClass("has-error");
            //输入框下面显示红色提示信息
            $("#helpBlock_add_inputEmail").text("输入邮箱格式不正确！");
            return false;
        }else {
            //移除格式
            $("#add_inputEmail").parent().parent().removeClass("has-error");
            $("#add_inputName").parent().parent().addClass("has-success");
            $("#helpBlock_add_inputEmail").hide();
        }
 */
		
		//alert("进入了");
		
		var empID = $("#add_inputempID").val();
		var empname = $("#add_inputName").val();
		var jobnum = $("#add_inputJobNum").val();
		var gender = $("input[type='radio']:checked").val();
		var dept_id = $("#add_department").val();
		var job_id = $("#add_inputJobId").val();
		
        $.ajax({
            url:"${pageContext.request.contextPath}/employee/addEmp",
            type:"GET",
            data:{"empID":empID,"empname":empname,"jobnum":jobnum,"gender":gender,"dept_id":dept_id,"job_id":job_id},
            contentType:"application/json;charset=UTF-8",
            success:function() {
                    alert("员工新增成功");
                    $('#emp-add-modal').modal("hide");
                    //跳往最后一页，由于新增记录，所以要重新查询总页数
                    $.ajax({
                        url:"${pageContext.request.contextPath}/employee/findTotalPages",
                        type:"GET",                    
                        success:function (data) {
                            var totalPage =data;
                            window.location.href="${pageContext.request.contextPath}/employee/findEmployeeAndPaging?pageNo="+totalPage;
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
