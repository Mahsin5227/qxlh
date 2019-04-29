<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-22
  Time: 下午4:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>

    <script>

        var newsId = ${news.id};
    </script>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp"%>
<div>
    <li>${news.title}</li>
    <li>${news.content}</li>
</div>

</body>
</html>
