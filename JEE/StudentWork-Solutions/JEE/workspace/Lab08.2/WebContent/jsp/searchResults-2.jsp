<%@ page errorPage="exception.jsp" %>
<%@ page import="java.util.*, com.javatunes.util.MusicItem" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="results" type="java.util.Collection<com.javatunes.util.MusicItem>" scope="request"/>	

<HTML>
   <HEAD>
      <TITLE>Search Results</TITLE>
   </HEAD>
   <BODY>
      <%@ include file="/jsp/header.jsp" %>
      Search results for keyword <B>${param.keyword}</B>:
      <BR/>
      
      <P>
      The number of items found is: <B>${size}</B>
	  </P>

	<ul>
      <%
         for (MusicItem item : results) {
      %>
      <li>
         <%=item.getId()%> <%=item.getTitle()%> <%=item.getArtist()%>
         <%=item.getReleaseDateString()%> <%=item.getListPrice()%> <%=item.getPrice()%>
      </li>
      <%
         }
      %>
      </ul>


   </BODY>
</HTML>
