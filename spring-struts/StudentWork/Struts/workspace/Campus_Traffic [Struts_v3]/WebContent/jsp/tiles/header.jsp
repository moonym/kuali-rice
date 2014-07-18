<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/headerStyle.css">
<div id="header">
	<a href="http://www.msu.edu"><img alt="Michigan State University" src="images/MSU-Wordmark-White-120-pxls.gif" /></a>
	<c:choose>
		<c:when test="${not empty username}">
			<ul>
				<li>Welcome, ${username}</li>
				<li class="selectable"><html:link action="/logout">Logout</html:link></li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li class="selectable">
					Login
					<html:form action="/logon">
						<p><html:text property="name" /></p>
						<p><html:password property="password" /></p>
						<p><html:submit value="Login" /></p>
					</html:form>
				</li>
			</ul>
		</c:otherwise>
	</c:choose>
	<div style="clear: both;"></div>
</div>