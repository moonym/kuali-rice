<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campus Traffic</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<form id="lots" method="post" action="${pageContext.request.contextPath}/lotGet">
		<select id="lotList" name="lotList" >
			<option value="79">Lot 79</option>
			<option value="80">Lot 80</option>
			<option value="81">Lot 81</option>
		</select>
		<input type="submit" value="Check Lot"/>
	</form>
</body>
</html>