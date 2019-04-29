<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-17
  Time: 上午10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
</head>
<body>

<div>
    <div>

        <form class="form-horizontal">
            <fieldset>
                <div id="legend" class="">
                    <legend class="">基本信息</legend>
                </div>
                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">学号</label>
                    <div class="controls">
                        <input type="text" placeholder="学号" class="input-xlarge">
                        <p class="help-block">帮助</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">姓名</label>
                    <div class="controls">
                        <input type="text" placeholder="姓名" class="input-xlarge">
                        <p class="help-block">请输入真实姓名</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">性别</label>
                    <div class="controls">
                        <input type="text" placeholder="性别" class="input-xlarge">
                        <p class="help-block">输入性别</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">院系</label>
                    <div class="controls">
                        <input type="text" placeholder="院系" class="input-xlarge">
                        <p class="help-block">Supporting help text</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">专业</label>
                    <div class="controls">
                        <input type="text" placeholder="专业" class="input-xlarge">
                        <p class="help-block">Supporting help text</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">学制</label>
                    <div class="controls">
                        <input type="text" placeholder="学制" class="input-xlarge">
                        <p class="help-block">Supporting help text</p>
                    </div>
                </div>

                <div class="control-group">

                    <!-- Text input-->
                    <label class="control-label" for="input01">年级</label>
                    <div class="controls">
                        <input type="text" placeholder="年级" class="input-xlarge">
                        <p class="help-block">Supporting help text</p>
                    </div>
                </div>

            </fieldset>
        </form>

    </div>
</div>

</body>
</html>
