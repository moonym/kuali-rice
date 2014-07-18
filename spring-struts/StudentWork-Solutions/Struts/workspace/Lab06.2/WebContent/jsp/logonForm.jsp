<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
	
<html:html>
  <head>
    <title>Logon Form</title>
    <!-- Optional client side validation -->
    <html:javascript formName="logonForm" />  
  </head>
  <body>
	<h2>Logon Example - Logon to JavaTunes</h2>

     <html:messages id="error" message="false"
		       header="errors.header" footer="errors.footer">
         <li>"${error}"</li>
     </html:messages>	

	<p>
  	<%-- TODO: Add in an struts html form element with action /logon --%>
  	<!-- Includes onSubmit for optional client side validation -->
	<html:form action="/logon" onsubmit="return validateLogonForm(this)">
	<%-- TODO: Add a struts text field with property name of name --%>
   	Name: <html:text property="name"/> <br/>
	<%-- TODO: Add a struts password field with property name password --%>
   	Password: <html:password property="password"/> <br/>
	<%-- TODO: Add in a struts submit bottom with value of Logon --%>
   	<html:submit value="Logon"/>
   	</html:form>
	</p>
	   
  </body>
</html:html>