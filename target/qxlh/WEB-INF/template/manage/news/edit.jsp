<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-30
  Time: 上午9:42
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
<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <%@include file="/WEB-INF/template/manage/common/header.jsp"%>
    </div>

</div>
<div class="layui-container fly-marginTop">
    <div class="fly-panel" pad20="" style="padding-top: 5px;">
        <!--<div class="fly-none">没有权限</div>-->
        <div class="layui-form layui-form-pane">
            <div class="layui-tab layui-tab-brief" lay-filter="user">
                <ul class="layui-tab-title">
                    <li class="layui-this">编辑新闻<!-- 编辑帖子 --></li>
                </ul>
                <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                    <div class="layui-tab-item layui-show">
                        <form class="layui-form" role="form" enctype="multipart/form-data" action="/manage/news/update" method="post">
                            <input type="hidden" class="form-control" name="id" value="${news.id}">
                            <div class="layui-row layui-col-space15 layui-form-item">
                                <div class="layui-col-md3">
                                    <label class="layui-form-label">所在专栏</label>
                                    <div class="layui-input-block">
                                        <select class="layui-select" name="cateId" id="cateId" data-type="selected" lay-filter="column" alt="栏目">
                                            <option value="" selected>=请选择栏目=</option>

                                            <c:forEach items="${cateList}" var="mainMenu">
                                                <option value="${mainMenu.id}">${mainMenu.name}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>
                                <div class="layui-col-md9">
                                    <label  class="layui-form-label">标题</label>
                                    <div class="layui-input-inline">
                                        <input type="text" class="layui-input" id="title" name="title" value="${news.title}" data-type="require">
                                    </div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">缩略图</label>
                                <div class="layui-col-sm-10">
                                    <div id="uploader" class="wu-example">
                                        <!--用来存放文件信息-->
                                        <input type="hidden" id="thumbnail" name="thumbnail">
                                        <div id="preview" class="uploader-list"></div>
                                        <div id="imagesList" class="uploader-list"></div>
                                        <div class="btns">
                                            <div id="picker">选择文件</div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                <label  class="layui-form-label">描述</label>
                                <div class="layui-input-block">
                                    <textarea rows="3" id ="description" name="description" class="layui-textarea">
                                        ${news.description}
                                    </textarea>
                                </div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                <div class="layui-input-block">

                                    <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="content">
                                        ${news.content}
                                    </textarea>

                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">来源</label>
                                <div class="layui-input-inline">
                                    <input type="text" class="layui-input" id="source" name="source" value="${news.source}">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label  class="layui-form-label">作者</label>
                                <div class="layui-input-inline">
                                    <input type="text" class="layui-input" value="${news.writer}" id="writer" name="writer">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <button class="layui-btn" lay-submit lay-filter="formDemo">保存</button>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>


    layui.use(['form','layedit'], function() {
        var form = layui.form,
            layer = layui.layer
            , layedit = layui.layedit
        //上传图片,必须放在 创建一个编辑器前面
        layedit.set({
            uploadImage: {
                url: '/upload/uploadImage' //接口url
                ,done: function (res) {
                    if(res.code == 0){
                        layer.alert("success");
                    }else {
                        layer.alert("failed");
                    }
                }
            }
        });

        //创建一个编辑器
        var index = layedit.build('content');
        form.verify({
            content: function(value){
                layedit.sync(index);
            }
        });

        // form.on('submit(formDemo)', function (data) {
        //     console.log(JSON.stringify(data.field));
        //
        //
        //     $.ajax({
        //         url: '/manage/news/save',
        //         type : 'post',
        //         data: data,
        //         timeout : 5000,
        //         error : function () {
        //             layer.close(index);
        //             $(":button").removeAttr("disabled");
        //             layer.msg("请求失败！");
        //         },
        //         success:function (result) {
        //             layer.close(index);
        //             $(":button").removeAttr("disabled");
        //             switch (result.code){
        //                 case 0:
        //                 case 1:
        //                 case 2:
        //                 case 3:
        //                     layer.msg(result.message, {icon: 6});
        //                     window.location.href = result.url;
        //                     break;
        //                 case -1:
        //                     layer.msg(result.message, {icon: 5});
        //                     break;
        //                 default:
        //                     layer.msg(result.message);
        //                     break;
        //             }
        //         }
        //
        //
        //     });
        //     return false;//只此一句
        // });

    });

</script>
</body>
</html>
