<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>签订合同</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <!--[if lt IE 9]>
    <script src="js/html5.js"></script>
    <![endif]-->
    <script src="../js/jquery.js"></script>
    <script src="../js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>
<body style="padding:20px">
    <div class="page_title">
        <h2 class="fl">签订合同</h2>
    </div>
    <table>
        <tr style="height:50px">
            <td style="text-align:right"><span class="item_name">员工姓名：</span></td>
            <td style="width:300px">张三</td>
            <td style="text-align:right"><span class="item_name">员工编号：</span></td>
            <td>00001</td>
        </tr>
        <tr style="height:50px">
            <td style="text-align:right"><span class="item_name">部门：</span></td>
            <td>开发部</td>
            <td style="text-align:right"><span class="item_name">职位：</span></td>
            <td>高级程序员</td>
        </tr>
        <tr style="height:50px">
            <td style="text-align:right"><span class="item_name">上次签订日期：</span></td>
            <td>2015-1-1</td>
            <td></td>
            <td></td>
        </tr>
        <tr style="height:50px">
            <td style="text-align:right"><span class="item_name">上次合同开始日期：</span></td>
            <td>2015-1-1</td>
            <td style="text-align:right"><span class="item_name">上次合同结束日期：</span></td>
            <td>2016-1-1</td>
        </tr>
        <tr style="height:50px">
            <td style="text-align:right"><span class="item_name">签订日期：</span></td>
            <td><input type="text" class="textbox textbox_225" /></td>
            <td></td>
            <td></td>
        </tr>
        <tr style="height:50px">
            <td style="text-align:right"><span class="item_name">本次合同开始日期：</span></td>
            <td><input type="text" class="textbox textbox_225" /></td>
            <td style="text-align:right"><span class="item_name">本次合同结束日期：</span></td>
            <td><input type="text" class="textbox textbox_225" /></td>
        </tr>
        <tr>
            <td style="text-align:right"><span class="item_name">备注：</span></td>
            <td colspan="3">
                <textarea placeholder="备注信息" class="textarea" style="width:580px;height:100px;"></textarea>
            </td>
        </tr>
        <tr style="height:50px">
            <td></td>
            <td colspan="3">
                <input type="button" value="保存" class="group_btn" />
                &nbsp;&nbsp;
                <input type="button" value="返回" class="group_btn" />
        </tr>
    </table>
</body>
</html>
