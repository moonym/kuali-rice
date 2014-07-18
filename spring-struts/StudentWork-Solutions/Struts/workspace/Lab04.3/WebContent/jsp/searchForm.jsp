<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html:html>
<head>
<title>searchForm</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<%-- Entries for the bean to populate the artists select --%>
<jsp:useBean id="artists" class="com.javatunes.util.Artists" />
<c:set var="optionValuesBean"  value="${artists.artistLabels}" />

<body>

<!--define form here -->
<html:form action="/search">

<table width="100%" bgcolor="#FFFF99">
      <tr valign="middle">
         <td>

        <!-- Create link to JavaTunes home -->
        <a href="/javatunes">JavaTunes</a>

         </td>
         <td valign="middle">
            <center>Search:
               <!-- define keyword field -->
               <html:text property="keyword"/>
               <!-- define searchArtist field -->
               <html:select property="searchArtist">
       		      <html:options collection="optionValuesBean" 
			         property="value" 
	 			     labelProperty="label"/>               
               </html:select>
                  
               <!-- define submit button Go -->
               <html:submit><bean:message key="button.search"/></html:submit>
			</center>
         </td>

         <td valign="middle">
               <%= new java.util.Date() %>
         </td>
      </tr>
   </table>
<!-- end define form here -->
</html:form>

</body>
</html:html>