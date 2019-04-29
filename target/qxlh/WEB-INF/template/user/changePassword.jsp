<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-17
  Time: 上午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <script src="../../../resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/user/changePassword.js"></script>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp"%>
<br>
<br>
<br>
<br>
<br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-8">
            <div class="animated fadeInDown">
                <div class="row login-panel">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <div class="ibox-content">
                            <h2 class="font-bold">修改密码</h2>
                            <form id = "qxlh_form" class="qxlh_form" action="${basePath}/user/changePassword">
                                <div class="form-group">
                                    旧密码
                                    <input id="oldPassword" name="oldPassword" class="form-control" type="password" data-type="require" alt="新密码">
                                </div>
                                <div class="form-group">
                                    新密码
                                    <input id="newPassword" name="newPassword" class="form-control" type="password" data-type="require" alt="新密码">
                                </div>
                                <div class="form-group">
                                    确认新密码
                                    <input id="renewPassword" name="renewPassword" class="form-control" type="password" data-type="require" data-rule="equal[newPassword]" alt="两次密码必须一致">
                                </div>
                                <center><button type="button" class="btn btn-primary m-b" onclick="changePwd()">修改密码</button></center>
                            </form>
                            <p></p>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>

<%@include file="/WEB-INF/template/common/footer.jsp"%>
</body>
</html>
