<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-17
  Time: 下午5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${basePath}/resource/js/common/jquery-2.1.1.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${basePath}/resource/js/common/jquery.form.js"></script>
    <script src="${basePath}/resource/layer/layer.js"></script>
    <script src="${basePath}/resource/js/student/add.js"></script>
</head>
<body>
<br>
<br>
<br>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3>
                基本信息
            </h3>

            <form id="qxlh-save-form" class="form-horizontal" action="${basePath}/student/save" method="post">
                <fieldset>
                    <div id="legend" class="">
                        <legend class="">基本信息</legend>
                    </div>
                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >学号</label>
                        <div class="controls">
                            <input type="text" id="number" name="number" placeholder="学号" class="input-xlarge">
                            <p class="help-block">学号</p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >教务处密码</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="教务系统密码" class="input-xlarge">
                            <p class="help-block">密码</p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >姓名</label>
                        <div class="controls">
                            <input type="text"  id="username" name="username" placeholder="姓名" class="input-xlarge">
                            <p class="help-block">姓名</p>
                        </div>
                    </div>


                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >身份证号码</label>
                        <div class="controls">
                            <input type="text"  id="identity_card" name="identity_card" placeholder="身份证号码" class="input-xlarge">
                            <p class="help-block">身份证号码</p>
                        </div>
                    </div>



                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >性别</label>
                        <div class="controls">
                            <input type="text"  id="gender" name="gender" placeholder="性别" class="input-xlarge">
                            <p class="help-block">性别</p>
                        </div>
                    </div>


                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >生日</label>
                        <div class="controls">
                            <input type="text" placeholder="生日" class="input-xlarge">
                            <p class="help-block">生日 </p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >手机号</label>
                        <div class="controls">
                            <input type="text"  id="mobile" name="mobile" placeholder="手机号" class="input-xlarge">
                            <p class="help-block">手机号</p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >学校</label>
                        <div class="controls">
                            <input type="text"  id="school" name="school" placeholder="学校" class="input-xlarge">
                            <p class="help-block">学校</p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >院系</label>
                        <div class="controls">
                            <input type="text"  id="college" name="college" placeholder="院系" class="input-xlarge">
                            <p class="help-block">院系</p>
                        </div>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >班级</label>
                        <div class="controls">
                            <input type="text"  id="mclass" name="mclass" placeholder="班级" class="input-xlarge">
                            <p class="help-block">班级</p>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">Button</label>

                        <!-- Button -->
                        <div class="controls">
                            <button type="button" class="btn btn-success" onclick="save()">保存</button>
                        </div>
                    </div>

                </fieldset>
            </form>

        </div>
    </div>
</div>
</body>
</html>
