<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>合同更改页面</title>
</head>
<body>
<div class="modal fade contract-update-modal" tabindex="-1" role="dialog" aria-labelledby="contract-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">合同更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_contract_form">
                    <div class="form-group">
                        <label for="update_contract_date" class="col-sm-2 control-label">签约日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="contract_date" class="form-control" id="update_contract_date" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_start_date" class="col-sm-2 control-label">起始日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="start_date" class="form-control" id="update_start_date" disabled="disabled">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="update_end_date" class="col-sm-2 control-label">结束日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="end_date" class="form-control" id="update_end_date" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_commment" class="col-sm-2 control-label">合同备注</label>
                        <div class="col-sm-8">
                            <input type="text" name="comment" class="form-control" id="update_comment">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="update_emp_id" class="col-sm-2 control-label">签约员工</label>
                        <div class="col-sm-8">
                            <input type="text" name="emp_id" class="form-control" id="update_emp_id" >
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary contract_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
     $(".contract_edit_btn").click(function () {
       id = $(this).parent().parent().find("td:eq(0)").text();
       // 根据id或name查询出对应员工信息进行回显；
       $.ajax({
           url:"${pageContext.request.contextPath}/contract/findContractById?id="+id,
           type:"GET",
           success:function (data) {                            
               $("#update_contract_date").val(data.contract_date);
               $("#update_start_date").val(data.start_date);
               $("#update_end_date").val(data.end_date);
               $("#update_comment").val(data.comment);
               $("#update_emp_id").val(data.emp_id);              
           }
       });
    }); 

    $(".contract_update_btn").click(function () {
/*         var contract_date = $("#update_contract_date").val();
        var start_date = $("#update_start_date").val(); */
        var end_date = $("#update_end_date").val();
        var comment = $("#update_comment").val();
        var emp_id = $("#update_emp_id").val();
        var curPageNo = ${curPageNo};
        $.ajax({
            url:"${pageContext.request.contextPath}/contract/updateContract/"+id,
            type:"GET",
            data:{"end_date":end_date,"comment":comment,"emp_id":emp_id,"id":id},
            success:function (data) {
                    alert("更新成功！");
                    window.location.href = "${pageContext.request.contextPath}/contract/getContractList?pageNo="+curPageNo;              
            },error:function(){
            	alert("更新失败");
            }
        });
    });
</script>
</body>
</html>
