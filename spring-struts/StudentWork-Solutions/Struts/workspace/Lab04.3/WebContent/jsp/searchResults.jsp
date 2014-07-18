<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
   <head>
      <title>Search Results</title>
   </head>
   <body>
      <h1>Java Tunes</h1>
      <h2>Your music solution!</h2>
      <hr/>
      
      <br/>
      Search results for keyword <b><c:out value="${param.keyword}"/> </b>:
      <br/>
      
      
      <table border="1">
      
          <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Artist</th>
              <th>Release</th>
              <th>List Price</th>
              <th>Your Price</th>   
              <th>Shop !</th>
          </tr>

         
          <c:forEach items="${results}" var="item">

          <tr>
              <!-- output id property of cd -->
              <td>${item.id}</td>

              <!-- output name property of cd -->
              <td>${item.title}</td>
              
              <!-- output artist property of cd -->
              <td>${item.artist}</td>
              
              <!-- output releaseDate -->
              <td>${item.releaseDateString}</td>
              
              <!-- output List Price -->
              <td>${item.listPrice}</td>

              <!-- output Your Price -->
              <td>
              <c:choose>
	            <c:when test="${item.price < 13}">
 		          <span style="color:green">
                </c:when>
		        <c:otherwise> 
		          <span style="color:red">
		        </c:otherwise>
               </c:choose>
              ${item.price}
              </span>  
              </td>

              <td>
              <!-- Output the shopping cart link -->
              <a href='<c:url value='/cart.do'><c:param name='itemID' value='${item.id}'/></c:url>'>Add to cart</a>
              </td>

              
          </tr>
          </c:forEach>
      

      
      </table>      

   </body>
</html>
