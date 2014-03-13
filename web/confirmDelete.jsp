<%--
    Document   : confirmDelete
    Created on : Mar 13, 2014, 1:47:54 PM
    Author     : Benjamin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Confirm Delete</title>
  </head>
  <body>
    <h1>Are you sure you want to delete conference code named ${param.cde}?</h1>
    <c:url value="/DeleteConferenceServlet" var="actionURL">
      <c:param name="cde" value="${param.cde}" />
    </c:url>
    <c:url value="/ConferenceStatusServlet" var="backURL" />
    <form action="${actionURL}" method="POST">
      <input type="submit" />
    </form>
  </body>
</html>
