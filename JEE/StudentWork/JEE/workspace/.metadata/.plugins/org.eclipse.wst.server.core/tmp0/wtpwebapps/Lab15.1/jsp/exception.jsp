<%@ page isErrorPage="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>Error Report</TITLE>
</HEAD>
<BODY>
<%@ include file="/jsp/header.jsp" %>
<b>You got an error.</b>
<br/>
The exception is: ${pageContext.exception.class.name}
<br/>
The message is: ${pageContext.exception.message}
<br/>
Request that generated the error: ${pageContext.errorData.requestURI}
<br/>
Status code: ${pageContext.errorData.statusCode}
<br/>
Exception information: ${pageContext.errorData.throwable}
</BODY>
</HTML>
