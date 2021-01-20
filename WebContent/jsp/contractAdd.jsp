<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>合同新增页面</title>
</head>
<body>
<div class="modal fade contract-add-modal" tabindex="-1" role="dialog" aria-labelledby="contract-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">合同新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_contract_form">
                     <div class="form-group">
                        <label for="add_contract_date" class="col-sm-2 control-label">签约日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="contract_date" class="form-control" id="add_contract_date" placeholder="签约日期">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_start_date" class="col-sm-2 control-label">起始日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="start_date" class="form-control" id="add_start_date" placeholder="起始日期">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="add_end_date" class="col-sm-2 control-label">结束日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="end_date" class="form-control" id="add_end_date" placeholder="结束日期">
                        </div>
                    </div>
                                       <div class="form-group">
                        <label for="add_comment" class="col-sm-2 control-label">合同状态</label>
                        <div class="col-sm-8">
                            <input type="text" name="comment" class="form-control" id="add_comment" placeholder="合同状态">
                        </div>
                    </div>
                                       <div class="form-group">
                        <label for="add_emp_id" class="col-sm-2 control-label">签约人</label>
                        <div class="col-sm-8">
                            <input type="text" name="emp_id" class="form-control" id="add_emp_id" placeholder="签约员工ID">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary contract_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
     $(".contract_add_btn").click(function () {
        $('.contract-add-modal').modal({
            backdrop:static,
            keyboard:true
        });

    }); 

    $(".contract_save_btn").click(function () {
        var contract_date = $("#add_contract_date").val();
        var start_date = $("#add_start_date").val();
        var end_date = $("#add_end_date").val();
        var comment = $("#add_comment").val();
        var emp_id = $("#add_emp_id").val();
        //验证省略...
        $.ajax({
            url:"${pageContext.request.contextPath}/contract/addContract",
            type:"GET",
            data:{"contract_date":contract_date,"start_date":start_date,"end_date":end_date,"comment":comment,"emp_id":emp_id},
            success:function (data) {
                    alert("添加成功");
                    $('.contract-add-modal').modal("hide");
                    $.ajax({
                        url:"${pageContext.request.contextPath}/contract/getTotalPages",
                        type:"GET",
                        success:function () {
                           var totalPage = ${totalPages};
                           window.location.href="${pageContext.request.contextPath}/contract/getContractList?pageNo="+totalPage;
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
