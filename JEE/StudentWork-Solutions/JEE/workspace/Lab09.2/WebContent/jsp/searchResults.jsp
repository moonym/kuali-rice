<%@ page errorPage="exception.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Search Results</TITLE>
</HEAD>
<BODY>

   <%@ include file="/jsp/header.jsp" %>

  <c:choose>
  <c:when test="${empty requestScope.results}">
    Sorry, your search produced no results.
  </c:when>
  <c:otherwise>
    
  Search results for keyword <B>${param.keyword}</B>:
  <BR>
  The number of items found is: ${fn:length(results)}<br/>

  <table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Artist</th>
        <th>Release Date</th>
        <th>List Price</th>
        <th><font color='green'>Your Price</font></th>
        <th><font color='blue'>Buy Now</font></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${results}" var="item">
      <tr>
        <td>${item.id}</td>
        <!--  Optional use of c:out -->
        <td><c:out value="${item.title}"/></td>
        <td>${item.artist}</td>
        <td><fmt:formatDate value="${item.releaseDate}" type="date" dateStyle="medium"/></td>
        <td><fmt:formatNumber value="${item.listPrice}" type="currency"/></td>
        <td><b><font color='green'><fmt:formatNumber value="${item.price}" type="currency"/></font></b></td>
        <td><a href="${pageContext.request.contextPath}/cart?itemID=${item.id}">Add to cart</a></td>
        <%-- Optional example with c:url
        <td><a href='<c:url value="/cart"><c:param name="itemID" value="${item.id}"/></c:url>'>Add to cart</a></td>
         --%>
      </tr>
      </c:forEach>
    </tbody>
  </table>

  </c:otherwise>
  </c:choose>

</BODY>
</HTML>
