<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-4-10
  Time: 下午5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>

    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/user/qxlhform.js"></script>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>
    <title>Title</title>
</head>
<body>

<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
    <li class="layui-nav-item">
        <a href="javascript:;">学校信息</a>
        <dl class="layui-nav-child">
            <dd><a href="javascript:;">选项一</a></dd>
            <dd><a href="javascript:;">选项二</a></dd>
            <dd><a href="javascript:;">选项三</a></dd>
            <dd><a href="">跳转项</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">新闻管理</a>
        <dl class="layui-nav-child">
            <dd><a href="/manage/news/index">新闻维护</a></dd>

        </dl>
    </li>
    <li class="layui-nav-item"><a href="/manage/trainprogram/index">培养方案</a></li>
    <li class="layui-nav-item"><a href="">学生信息</a></li>
</ul>

<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块


    });
</script>

</body>
</html>
