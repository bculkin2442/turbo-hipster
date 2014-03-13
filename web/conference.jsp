<%--
    Document   : conference
    Created on : Mar 12, 2014, 10:37:47 AM
    Author     : Benjamin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <table style="border: 1px solid black">
      <thead>
        <tr style="">
          <td> All conferences</td>
        </tr>
        <tr>
          <td>
            Code name
          </td>
          <td>
            Location
          </td>
          <td>
            Duration
          </td>
          <td>
            Edit
          </td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${conferences}" var="conf">
          <tr>
            <td>
              ${conf.cde}
            </td>
            <td>
              ${conf.loc}
            </td>
            <td>
              <fmt:formatDate pattern="MM/dd/yyyy"
                              value="${conf.dur.start}" var="fancyStart" />
              <fmt:formatDate pattern="MM/dd/yyyy"
                              value="${conf.dur.finish}" var="fancyFinish" />
              Starting on ${fancyStart} and ending on ${fancyFinish}
            </td>
            <td>
              <c:url value="/ConferenceDetailServlet" var="editURL">
                <c:param name="cde" value="${conf.cde}" />
              </c:url>
              <a href="${editURL}"> Edit </a>
            </td>
            <td>
              <c:url value="/confirmDelete.jsp" var="deleteURL">
                <c:param name="cde" value="${conf.cde}" />
              </c:url>
              <a href="${deleteURL}"> Delete </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <c:url value="/addConference.jsp" var="addURL"/>
    <a href="${addURL}"> Register a new conference </a>
  </body>
</html>
