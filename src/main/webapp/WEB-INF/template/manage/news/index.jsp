<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-4-10
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${basePath}/resource/bootstrap-4.3.1-dist/css/bootstrap.css" rel="stylesheet">
    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/resource/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/user/qxlhform.js"></script>
    <%--<link rel="stylesheet" href="${bathPath}/resource/layui/css/layui.css">--%>
    <%--<script src="${bathPath}/resource/layui/layui.js"></script>--%>
    <script src="${basePath}/resource/js/common/extendPagination.js"></script>
</head>

<body>

<div class="wrapper">
    <div class="content-wrapper">
    <section class="content-header">
        <h1>新闻(${model.pageInfo.total})</h1>
        <ol class="breadcrumb">
            <li><a href="/manage/index"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li class="active">新闻管理</li>
        </ol>
    </section>
    
    <section class="content">
        <div class="row">
            <div class="col-md-2">
                <div class="box box-solid">
                    <div class="box-header with-border">
                        <h3 class="box-title">栏目</h3>
                        <div class="box-tools">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                    class="fa fa-minus"></i></button>
                        </div>
                    </div>
                    <div class="box-body no-padding">
                        <ul class="nav nav-pills nav-stacked">
                            <li <c:if test= "${cateid ==''}"> class="active" </c:if>>
                                <a href="${managePath}/manage/news/index">
                                    <i class="fa fa-circle-o text-light-blue"></i>全部
                                </a>
                            </li>
                            <c:forEach items="${cateList}" var = "mainMenu">
                             <li <c:if test="${cateid==mainMenu.id}" > class="active"</c:if>>
                                 <a href="${managePath}/manage/news/index?cateid=${mainMenu.id}">
                                        <i class="fa fa-circle-o text-light-blue"></i>
                                        ${mainMenu.name}
                                </a>
                             </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-md-10">
                <div class="box box-primary">
                    <div class="box-header">
                        <h3 class="box-title">
                            <a href="/manage/news/add"
                               title="发布新闻" width="1000px" height="680px">
                                <span class="label label-info">发布</span>
                            </a>
                        </h3>

                        <div class="box-tools">
                            <form method="get" action="/manage/news/index">
                                <div class="input-group input-group-sm" style="width: 350px;">
                                    <input type="text" name="key" class="form-control pull-right"
                                           placeholder="请输入关键词">
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th style="width: 10px">#</th>
                                <th>标题</th>
                                <th>所在栏目</th>
                                <th>创建时间</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${model.data}" var="news">
                            <tr>
                                <td>${news.id}</td>
                                <td>${news.title}</td>
                                <td>${news.newsCate.name}</td>
                                <td><fmt:formatDate value="${news.createTime}"  pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>
                                    <c:if test ="${news.status==0}">
                                        <a class="marg-l-5" target="_qxlhLink"
                                           href="/manage/news/audit/${news.id}">
                                            <span class="label label-danger">未审核</span>
                                        </a>
                                    </c:if>
                                    <c:if test ="${news.status==1}">
                                        <a class="marg-l-5" target="_qxlhLink"
                                           href="/manage/news/audit/${news.id}">
                                            <span class="label label-success">已审核</span>
                                        </a>
                                    </c:if>

                                </td>
                                <td>
                                    <a href="/manage/news/edit/${news.id}" target="_jeesnsOpen"
                                       title="编辑文章" width="1000px" height="680px">
                                        <span class="label label-warning">编辑</span>
                                    </a>
                                    <a class="marg-l-5" target="_qxlhLink"
                                       href="/manage/news/delete/${news.id}" confirm="确定要删除文章吗？">
                                        <span class="label label-danger">删除</span>
                                    </a>
                                </td>
                            </tr>


                            </c:forEach>
                            </tbody>
                        </table>
                    </div>



                    <div class="box-footer clearfix">
                        <ul class="pagination"
                            url="${managePath}/manage/news/index?key=${key}"
                            currentPage="${model.page.pageNo}"
                            pageCount="${model.pageInfo.pages}">

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</div>
    <script type="text/javascript">
        $(function () {
            $(".pagination").paginate();
        });
    </script>
</body>
</html>
