<%--
  Created by IntelliJ IDEA.
  User: ltt
  Date: 19-3-18
  Time: 下午10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%--<%@ page isELIgnored="false"%>--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>加法网页</title>
    </head>
    <body>
      ${param.a}+${param.b} = ${param.a + param.b}
    </body>
</html>
