<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-4-1
  Time: 上午10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
<script src="${bathPath}/resource/layui/layui.js"></script>
</head>
<%@include file="/WEB-INF/template/common/header.jsp"%>
<div class="layui-col-md4">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">学校简介</a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">武汉大学</a></dd>
                <dd><a href="javascript:;">华中科技大学</a></dd>
                <dd><a href="javascript:;">中国地质大学</a></dd>
                <dd><a href="">跳转项</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item">
            <a href="javascript:;">学校培养方案</a>
            <dl class="layui-nav-child">
                <dd><a href="">移动模块</a></dd>
                <dd><a href="">后台模版</a></dd>
                <dd><a href="">电商平台</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="">云市场</a></li>
        <li class="layui-nav-item"><a href="/links/list">七校友情链接</a></li>
    </ul>
</div>


<div class="layui-col-md8">

    <c:forEach items="${model.data}" var="university">
        <li>${university.name}</li>

    </c:forEach>
</div>

</body>
</html>
