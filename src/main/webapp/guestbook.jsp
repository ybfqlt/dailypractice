<%--
  Created by IntelliJ IDEA.
  User: ltt
  Date: 19-4-8
  Time: 下午5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set target="${pageContext.request}" property="characterEncoding" value="UTF-8"/>
<jsp:useBean id="guestbook" class="com.openhome.GuestBookBean" scope="application"/>
<c:if test="${parm.msg != null}">  <-- url上给出的值-->
    <jsp:useBean id="newMessage" class="com.openhome.Message" />
    <jsp:setProperty name = "newMessage" property="*"/>
    <C:set target="${guestbook}" property="message" value="${newMessage}"/>
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//NE" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>访客留言板</title>
</head>
<body>
   <table style="text-align: left; width: 100%;" border="0" cellpadding="2" cellspacing="2">
       <tbody>
          <c:forEach var="message" items="${guestbook.messages}">
              <tr>
                  <td>${message.name}</td>
                  <td>${message.email}</td>
                  <td>${message.msg}</td>
              </tr>
          </c:forEach>
       </tbody>
   </table>
</body>
</html>
