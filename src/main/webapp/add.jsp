<%--
  Created by IntelliJ IDEA.
  User: ltt
  Date: 19-3-18
  Time: 下午5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" errorPage ="error.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>加法网页</title>
</head>
<body>
<%
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    out.println("a + b = "+(Integer.parseInt(a) + Integer.parseInt(b)));
%>
</body>
</html>
