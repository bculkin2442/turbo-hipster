<%--
    Document   : editConference
    Created on : Mar 13, 2014, 9:50:01 AM
    Author     : Benjamin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit a conference</title>
  </head>
  <body>
    <h1> Editing conference code named ${curConf.cde}</h1>
    <c:url value="/UpdateConferenceServlet?cde=${curConf.cde}" var="actionURL" />
    <form action="${actionURL}" method="POST">
      <table>
        <tr>
          <td>
            Location: <input type="text" name ="loc" value="${curConf.loc}"/>
          </td>
        </tr>
        <tr>
          <td>
            <fmt:formatDate pattern="MM/dd/yyyy"
                            value="${curConf.dur.start}" var="fancyStart" />
            Start date (MM/DD/YYYY):
            <input type="date" name="start" value="${fancyStart}"/>
          </td>
        </tr>
        <tr>
          <td>
            <fmt:formatDate pattern="MM/dd/yyyy"
                            value="${curConf.dur.finish}" var="fancyFinish" />
            Finish date (MM/DD/YYYY):
            <input type="date" name="finish" value="${fancyFinish}"/>
          </td>
        </tr>
        <input type="submit" />
      </table>
    </form>
  </body>
</html>
