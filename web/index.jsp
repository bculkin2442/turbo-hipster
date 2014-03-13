<%--
    Document   : index
    Created on : Mar 10, 2014, 4:35:18 PM
    Author     : Benjamin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Conference Management</title>
  </head>
  <body>
    <h1>Welcome to conference management!</h1>
    <h2> Please choose a action to perform</h2>
    <table>
      <tbody>
        <tr>
          <td>
            <c:url value="/ConferenceStatusServlet" var="url" />
            <a href="${url}">Conference Status</a>
          </td>
        </tr>
      </tbody>
  </body>
</html>
