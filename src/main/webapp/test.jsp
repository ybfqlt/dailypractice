<%--
  Created by IntelliJ IDEA.
  User: ltt
  Date: 19-4-8
  Time: 上午11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--设置bean性质，关键字set，target-->
<html>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% com.openhome.person person = new com.openhome.person(); %>
<% pageContext.setAttribute("person",person);%>
set bean<br>
<c:set target="${person}" property="name" value="bigMan" />
personName:
<c:out value="${person.name}" /><br>
</body>
</html>