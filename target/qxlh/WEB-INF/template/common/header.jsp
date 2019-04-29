<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-6
  Time: 上午11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="${basePath}/">首页</a></li>
    <li class="layui-nav-item"><a href="${basePath}/news/list">新闻公告</a></li>
    <li class="layui-nav-item"><a href="${basePath}/collegeInfo/">学校信息</a>
        <dl class="layui-nav-child">
            <dd><a href="${basePath}/collegeInfo/introduce/list">学校介绍</a></dd>
            <dd><a href="${basePath}/collegeInfo/news/list">学校新闻动态</a></dd>
            <dd><a href="${basePath}/user/login">学校培养方案</a></dd>
            <dd><a href="${basePath}/links/list">七校友情连接</a></dd>
        </dl>

    </li>
    <li class="layui-nav-item"><a href="">培养方案</a></li>
    <li class="layui-nav-item  layui-layout-right">
        <a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">用户${loginUser.name}</a>
        <dl class="layui-nav-child">
            <c:choose>
                <c:when test="${empty loginUser}">
                    <dd><a href="${basePath}/user/login">登陆</a></dd>
                    <dd><a href="${basePath}/user/register">注册</a></dd>
                </c:when>
                <c:otherwise>

                    <dd><a href="${basePath}/user/index">个人信息</a></dd>
                    <dd><a href="javascript:;">信息管理</a></dd>
                    <dd><a href="${basePath}/user/logout" >退出登陆</a></dd>
                </c:otherwise>
            </c:choose>
        </dl>
    </li>

</ul>

<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>