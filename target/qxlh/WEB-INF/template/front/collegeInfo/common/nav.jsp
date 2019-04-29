<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-4-1
  Time: 上午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
<script src="${bathPath}/resource/layui/layui.js"></script>
</head>
<%@include file="/WEB-INF/template/common/header.jsp"%>

<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
    <li class="layui-nav-item">
        <a href="${bathPat}/collegeInfo/detail/whu">武汉大学</a>

    </li>
    <li class="layui-nav-item">
        <a href="javascript:;">华中科技大学</a>

    </li>
    <li class="layui-nav-item"><a href="">武汉理工大学</a></li>
    <li class="layui-nav-item"><a href="">中南财经政法大学</a></li>
    <li class="layui-nav-item"><a href="">中国地质大学</a></li>
    <li class="layui-nav-item"><a href="">中南民族大学</a></li>
</ul>
