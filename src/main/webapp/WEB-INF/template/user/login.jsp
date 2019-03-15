<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-6
  Time: 上午11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = "";
    String password = "";
    //获取当前站点的所有Cookie
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
        if ("name".equals(cookies[i].getName())) {
            name = cookies[i].getValue();
        } else if ("password".equals(cookies[i].getName())) {
            password = cookies[i].getValue();
        }
    }
%>
<html>
<head>
    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/user/login.js"></script>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="layui-container">
    <div class="row login-panel">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="ibox ibox-content">
                <h2 class="font-bold">登录</h2>
                <div class="text-muted text-center">
                    <form class="m-t" id="qxlh_login_form" action="${basePath}/user/login" method="post">
                        <input type="hidden" name="redirectUrl" value="${redirectUrl}">
                        <div class="form-group">
                            用户名/邮箱
                            <input type="text" id="name" class="form-control" name="name" placeholder="用户名/邮箱" data-type="require">
                        </div>
                        <div class="form-group">
                            密码
                            <input type="password" id="password" class="form-control" name="password" placeholder="密码"
                   data-type="require">
                        </div>
                        <div>
                            <input name="rememberme" type="checkbox" id="flag" value="1" /> 记住密码
                        </div>
                        <button type="button" class="btn btn-primary block full-width m-b" onclick="login()">登录</button>
                    </form>

                    <p class="text-muted text-center">
                        <a href="${basePath}/user/forgetpwd">忘记密码?</a>
                        <a href="${basePath}/user/register">我要注册</a>
                    </p>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
