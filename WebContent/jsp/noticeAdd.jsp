<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>公告新增页面</title>
</head>
<body>
<div class="modal fade notice-add-modal" tabindex="-1" role="dialog" aria-labelledby="notice-add-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">公告新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal add_notice_form">
                     <div class="form-group">
                        <label for="add_title" class="col-sm-2 control-label">公告标题</label>
                        <div class="col-sm-8">
                            <input type="text" name="title" class="form-control" id="add_title" placeholder="公告标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add_context" class="col-sm-2 control-label">公告内容</label>
                        <div class="col-sm-8">
                            <input type="text" name="context" class="form-control" id="add_context" height="400px" placeholder="公告内容">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="add_create_date" class="col-sm-2 control-label">发布日期</label>
                        <div class="col-sm-8">
                            <input type="date" name="create_date" class="form-control" id="add_create_date" placeholder="发布日期">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="add_user_id" class="col-sm-2 control-label">发布人</label>
                        <div class="col-sm-8">
                            <input type="text" name="user_id" class="form-control" id="add_user_id" placeholder="发布人ID">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary notice_save_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script type="text/javascript">
     $(".notice_add_btn").click(function () {
        $('.notice-add-modal').modal({
            backdrop:static,
            keyboard:true
        });

    }); 

    $(".notice_save_btn").click(function () {
        var title = $("#add_title").val();
        var context = $("#add_context").val();
        var create_date = $("#add_create_date").val();
        var user_id = $("#add_user_id").val();
        $.ajax({
            url:"${pageContext.request.contextPath}/notice/addNotice",
            type:"GET",
            data:{"title":title,"context":context,"create_date":create_date,"user_id":user_id},
            success:function (data) {
                    alert("添加成功");
                    $('.notice-add-modal').modal("hide");
                    $.ajax({
                        url:"${pageContext.request.contextPath}/notice/getTotalPages",
                        type:"GET",
                        success:function (data) {
                           var totalPage = data;
                           window.location.href="${pageContext.request.contextPath}/notice/getNoticeList?pageNo="+totalPage;
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
