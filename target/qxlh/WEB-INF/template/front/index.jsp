<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-6
  Time: 上午11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../../resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">
    <script src="${bathPath}/resource/layui/layui.js"></script>
</head>
<body>
<%@include file="/WEB-INF/template/common/header.jsp"%>
<div class="layui-carousel" id="test1">
    <div carousel-item>
        <c:forEach items="${newsModel.data}" var="article">

                <div class="thumbnail">
                    <img src="${article.thumbnail}" alt="" href="/${bashPath}/news/detail/${article.id}" >
                    <div class="caption">
                        <a href="${bashPath}/news/detail/${article.id}"><h3>${article.title}</h3></a>
                        <p>${article.description}</p>

                    </div>
                </div>
        </c:forEach>

    </div>
</div>
<!-- 条目中可以是任意内容，如：<img src=""> -->

<script src="/static/build/layui.js"></script>
<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
</script>



<div class="layui-row">
<%@include file="/WEB-INF/template/common/footer.jsp"%>
</div>
</body>
</html>
