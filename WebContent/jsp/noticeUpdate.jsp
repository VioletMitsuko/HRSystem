<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>公告更改页面</title>
</head>
<body>
<div class="modal fade notice-update-modal" tabindex="-1" role="dialog" aria-labelledby="notice-update-modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">公告更改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal update_notice_form">
                    <div class="form-group">
                        <label for="update_title" class="col-sm-2 control-label">公告标题</label>
                        <div class="col-sm-8">
                            <input type="text" name="title" class="form-control" id="update_title" placeholder="公告标题">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="update_context" class="col-sm-2 control-label">公告内容</label>
                        <div class="col-sm-8">
                            <input type="text" name="context" class="form-control" id="update_context" height="400px" placeholder="公告内容">
                        </div>
                    </div>
                   <div class="form-group">
                        <label for="update_user_id" class="col-sm-2 control-label">发布人</label>
                        <div class="col-sm-8">
                            <input type="text" name="user_id" class="form-control" id="update_user_id" placeholder="发布人ID">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary notice_update_btn">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">
     $(".notice_edit_btn").click(function () {
       id = $(this).parent().parent().find("td:eq(0)").text();
    }); 

    $(".notice_update_btn").click(function () {
        var title = $("#update_title").val();
        var context = $("#update_context").val();
        var user_id = $("#update_user_id").val();
        var curPageNo = ${curPageNo};
        $.ajax({
            url:"${pageContext.request.contextPath}/notice/updateNotice/"+id,
            type:"GET",
            data:{"title":title,"context":context,"user_id":user_id},
            success:function (data) {
                    alert("更新成功！");
                    window.location.href = "${pageContext.request.contextPath}/notice/getNoticeList?pageNo="+curPageNo;              
            },error:function(){
            	alert("更新失败");
            }
        });
    });
</script>
</body>
</html>
