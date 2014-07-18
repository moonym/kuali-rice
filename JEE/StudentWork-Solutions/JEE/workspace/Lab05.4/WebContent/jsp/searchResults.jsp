<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Search Results</TITLE>
</HEAD>
<BODY>
  <%@ include file="/jsp/header.jsp" %>
  Search results for keyword <B>${param.keyword}</B>:
  <BR>
  Number of results for search: ${size}<br/>
  (Full results to be implemented)<br/>

  <h2>Optional parts</h2>
  The host is: ${header["host"]}<br/>
  Search results for keyword <B>${param["keyword"]}</B>:<br/>
  Number of results for search: ${requestScope.size}<br/>  
</BODY>
</HTML>
