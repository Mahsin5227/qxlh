<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-6
  Time: 上午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="m-t jeesns_form" action="${basePath}/user/register" method="post">
    <div class="form-group">
        用户名
        <input type="text" name="name" class="form-control" placeholder="用户名" data-type="require">
    </div>
    <div class="form-group">
        手机号
        <input type="text" name="mobile" class="form-control" placeholder="手机号" data-type="require">
    </div>
    <div class="form-group">
        邮箱
        <input type="text" name="email" class="form-control" placeholder="邮箱" data-type="require">
    </div>

    <div class="form-group">
        密码
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" data-type="require">
    </div>
    <div class="form-group">
        确认密码
        <input type="password" name="repassword" class="form-control" placeholder="确认密码" data-type="require" data-rule="equal[password]">
    </div>
    <button type="submit" class="btn btn-primary block full-width m-b">注册</button>
    <p></p>
    <p class="text-muted text-center">
        <a href="forgetpwd">忘记密码?</a>
        <a href="login">我要登录</a>
    </p>
</form>
</body>
</html>
