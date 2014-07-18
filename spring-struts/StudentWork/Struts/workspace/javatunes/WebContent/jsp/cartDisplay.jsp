<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
   <head>
      <title>Your Cart</title>
   </head>
   <body>
      <h1>Java Tunes</h1>
      <h2>Your music solution!</h2>
      <hr/>
      
      <br/>
      Shopping cart contains:
      <br/>
      
      
      <table border="1">
      
          <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Artist</th>
              <th>Release</th>
              <th>List Price</th>
              <th>Your Price</th>   
          </tr>

         
          <c:forEach items="${cart}" var="item">

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
              <td>${item.price}</td>
              
          </tr>
          </c:forEach>
      

      
      </table>      

   </body>
</html>
