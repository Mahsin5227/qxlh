<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-22
  Time: 下午4:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻公共</title>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp"%>

<c:forEach items="${model.data}" var="news">
    <li>${news.newsCate.name}</li>
    <li><a href="/news/detail/${news.id}">${news.title}</a></li>

</c:forEach>



<%@include file="/WEB-INF/template/common/footer.jsp"%>
</body>
</html>
