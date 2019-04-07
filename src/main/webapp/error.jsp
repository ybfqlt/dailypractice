<%--
  Created by IntelliJ IDEA.
  User: ltt
  Date: 19-3-18
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding ="UTF-8" isErrorPage="true"%>
<%@ page import="java.io.PrintWriter"%>
<html>
<head>
    <title>错误</title>
</head>
<body>
<h1>网页发生错误: </h1><%= exception %>
<h2>显示异常堆栈跟踪: </h2>
<%
    exception.printStackTrace(new PrintWriter(out));
%>
</body>
</html>