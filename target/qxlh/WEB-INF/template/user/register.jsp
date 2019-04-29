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
    <title>注册</title>

    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/user/qxlhform.js"></script>

    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>

</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp"%>
<div class="layui-container layui-main">
    <div class="layui-panel-window">
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title">

                <li><a href="${basePath}/user/login">登陆</a></li>
                <li class="layui-this">注册</li>
            </ul>

            <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form layui-form-pane">
                        <form class="layui-form" id="qxlh_form" action="${basePath}/user/register" method="post">
                            <input type="hidden" name="redirectUrl" value="${redirectUrl}">



                            <div class="layui-form-item">
                                <label for="name" class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="name" class="layui-input" name="name" placeholder="用户名" data-type="require">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="email" class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="email" class="layui-input" name="email" placeholder="邮箱" data-type="require">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="mobile" class="layui-form-label">手机号</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="mobile" class="layui-input" name="mobile" placeholder="手机号码" data-type="require">
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label for="password" class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="password" class="layui-input" name="password" placeholder="密码" data-type="require">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label for="repassword" class="layui-form-label">确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id = "repassword" name="repassword" class="layui-input" placeholder="确认密码" data-type="require" data-rule="equal[password]">
                                </div>
                            </div>
                            <button type="submit" class="layui-btn">注册</button>
                        </form>
                    </div>

                    <p class="text-muted text-center">
                        <a href="${basePath}/user/forgetpwd">忘记密码?</a>
                        <a href="${basePath}/user/register">我要注册</a>
                    </p>

                </div>
            </div>
        </div>
    </div>
</div>


<%--<form class="m-t jeesns_form" action="${basePath}/user/register" method="post">--%>
    <%--<div class="form-group">--%>
        <%--用户名--%>
        <%--<input type="text" name="name" class="form-control" placeholder="用户名" data-type="require">--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--手机号--%>
        <%--<input type="text" name="mobile" class="form-control" placeholder="手机号" data-type="require">--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--邮箱--%>
        <%--<input type="text" name="email" class="form-control" placeholder="邮箱" data-type="require">--%>
    <%--</div>--%>

    <%--<div class="form-group">--%>
        <%--密码--%>
        <%--<input type="password" id="password" name="password" class="form-control" placeholder="密码" data-type="require">--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--确认密码--%>
        <%--<input type="password" name="repassword" class="form-control" placeholder="确认密码" data-type="require" data-rule="equal[password]">--%>
    <%--</div>--%>
    <%--<button type="submit" class="btn btn-primary block full-width m-b">注册</button>--%>
    <%--<p></p>--%>
    <%--<p class="text-muted text-center">--%>
        <%--<a href="forgetpwd">忘记密码?</a>--%>
        <%--<a href="login">我要登录</a>--%>
    <%--</p>--%>
<%--</form>--%>
</body>
</html>
