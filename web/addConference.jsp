<%--
    Document   : addConference
    Created on : Mar 12, 2014, 5:52:55 PM
    Author     : Benjamin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register a conference</title>
  </head>
  <body>
    <c:url value="/RegisterConferenceServlet" var="submitURL"/>

    <form method="POST" action="${submitURL}">
      Code Name: <input type="text" name="cde" placeholder="Conference code name"/>
      <br />
      Location: <input type="text" name="loc" placeholder="Conference location"/>
      <br />
      Start date (MM/DD/YYYY): <input type="date" name="start"/>
      <br />
      End date (MM/DD/YYYY): <input type="date" name="end"/>
      <input type="submit" />
    </form>
  </body>
</html>
