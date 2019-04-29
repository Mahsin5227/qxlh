<%--
  Created by IntelliJ IDEA.
  User: mahsin
  Date: 19-3-31
  Time: 上午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传下载</title>
</head>
<body>
<form action="${bathPath}/uploadFile" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file" width="120px"> <input
        type="submit" value="上传">
</form>

</body>
</html>
