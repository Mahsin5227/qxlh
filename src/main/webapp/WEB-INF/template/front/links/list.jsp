<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-23
  Time: 下午3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>友情连接</title>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>
</head>
<body>

<%@include file="/WEB-INF/template/common/header.jsp"%>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6">
            <c:forEach items="${linkModel.data}" var="link">

                <div class="layui-card">
                    <div class="layui-card-header">
                        <li><a href="${link.url}" target="_blank">${link.name}</a></li>
                    </div>
                    <div class="layui-card-body">
                        卡片式面板面板通常用于非白色背景色的主体内<br>
                        从而映衬出边框投影
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">标题</div>
                <div class="layui-card-body">
                    内容
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/template/common/footer.jsp"%>
</body>
</html>
