<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-4-1
  Time: 上午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>

    <title></title>
</head>

<body>
<%@include file="/WEB-INF/template/common/header.jsp"%>
    <div class="layui-col-md4">
        <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
            <li class="layui-nav-item">
                <a href="${bathPath}/collegeInfo/news/detail/whu">武汉大学</a>

            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">华中科技大学</a>

            </li>
            <li class="layui-nav-item"><a href="">武汉理工大学</a></li>
            <li class="layui-nav-item"><a href="">中南财经政法大学</a></li>
            <li class="layui-nav-item"><a href="">中国地质大学</a></li>
            <li class="layui-nav-item"><a href="">中南民族大学</a></li>
        </ul>
    </div>
    <div class="layui-col-md8">
        <c:forEach items="${model.data}" var="news">
            <li>${news.newsCate.name}</li>
            <li><a href="/news/detail/${news.id}">${news.title}</a></li>

        </c:forEach>
    </div>
</body>
</html>