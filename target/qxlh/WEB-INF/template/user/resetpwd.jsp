<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-19
  Time: 下午4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/user/qxlhform.js"></script>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>

</head>
<body>

<body class="gray-bg">

<div class="animated fadeInDown">
    <div class="row login-panel">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="ibox-content">
                <h2 class="font-bold">重置密码</h2>
                <form class="m-t jeesns_form" action="${basePath}/user/resetpwd" method="post">
                    <input name="email" class="form-control" type="hidden" value="${email}">
                    <input name="token" class="form-control" type="hidden" value="${token}">
                    <div class="form-group">
                        新密码
                        <input id="newPassword" name="password" class="form-control" type="password" data-type="require"
                               alt="新密码">
                    </div>
                    <div class="form-group">
                        确认新密码
                        <input id="renewPassword" name="repassword" class="form-control" type="password"
                               data-type="require" data-rule="equal[newPassword]" alt="两次密码必须一致">
                    </div>
                    <button type="button" class="btn btn-primary m-b" onclick="resetpwd()">重置密码</button>
                </form>
                <p></p>

            </div>
        </div>
    </div>
</div>

</body>
</body>
</html>
