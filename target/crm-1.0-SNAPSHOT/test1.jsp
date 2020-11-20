<%--
  Created by IntelliJ IDEA.
  User: haoyu
  Date: 2020/11/16
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
    $.ajax({
    url:"",
    data:{

    },
    type:"",
    dataType:"json",
    success:function (data) {

    }

    });

    String  createTime= DateTimeUtil.getSysTime();

    String  createBy=((User)request.getSession().getAttribute("user")).getName();

</body>
</html>
