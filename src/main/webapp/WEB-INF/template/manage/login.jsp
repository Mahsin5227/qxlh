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

    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/user/qxlhform.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="七校联合">
    <meta name="description" content="七校联合办学项目">
    <link rel="stylesheet" href="${basePath}/resource/layui/css/layui.css">
    <script src="${basePath}/resource/layui/layui.js"></script>

    <meta charset="UTF-8">
    <title>登陆</title>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp"%>

<div class="layui-container layui-main">
    <div class="layui-panel-window">
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title">
                <li class="layui-this">登入</li>
            </ul>

            <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form layui-form-pane">
                        <form class="layui-form" id="qxlh_login_form" action="${basePath}/manage/login" method="post">
                            <input type="hidden" name="redirectUrl" value="${redirectUrl}">



                            <div class="layui-form-item">
                                <label for="name" class="layui-form-label">邮箱/用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="name" class="layui-input" name="name" placeholder="用户名/邮箱" data-type="require">
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label for="password" class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="password" class="layui-input" name="password" placeholder="密码" data-type="require">
                                </div>
                            </div>
                            <div>
                                <input name="rememberme" type="checkbox" id="flag" value="1" class="layui-form-checkbox"/> 记住密码
                            </div>
                            <button type="submit" class="layui-btn">登录</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
