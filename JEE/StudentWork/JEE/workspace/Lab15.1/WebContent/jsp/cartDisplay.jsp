<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Shopping Cart Contents</TITLE>
</HEAD>
<BODY>
  <%@ include file="/jsp/header.jsp" %>

  <c:choose>
  <c:when test="${empty sessionScope.cart}">
    Your shopping cart is empty.
  </c:when>
  <c:otherwise>

  Your shopping cart contains: 
  <table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Artist</th>
        <th>Release Date</th>
        <th>List Price</th>
        <th><font color='green'>Your Price</font></th>
      </tr>
    </thead>
    <tbody>
      <c:set var="total" value="0"/>

      <c:forEach items="${cart}" var="item">
      <tr>
        <td>${item.id}</td>
        <td>${item.title}</td>
        <td>${item.artist}</td>
        <td><fmt:formatDate value="${item.releaseDate}" type="date" dateStyle="long"/></td>
        <td><fmt:formatNumber value="${item.listPrice}" type="currency"/></td>
        <td><b><font color='green'><fmt:formatNumber value="${item.price}" type="currency"/></font></b></td>
      </tr>
       <c:set var="total" value="${total + item.price}"/>
      </c:forEach>

    </tbody>
  </table>
  The total cost of your order is: <b><font color='green'><fmt:formatNumber value="${total}" type="currency"/></font></b>

  </c:otherwise>
  </c:choose>

</BODY>
</HTML>
