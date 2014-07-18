<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= request.getParameter("keyword") %></title>

<style>
#form{background-color:#c8c8c8;color:#fff;border:#000 2px solid}
a:link{color:#000;text-decoration:none;}
a:visited{color:#000;text-decoration:none;}
a:hover{color:#fff;text-decoration:none;}
</style>

</head>
<body>

	<%@ include file="header.jsp" %>
	<c:choose>
		<c:when test='${empty results}'><p>Your search has no results.</c:when>
		<c:otherwise>
			<p>You searched for: ${param.keyword}</p>
			
			<p>There are ${size} matches in the collection.</p>
			<hr/>
		
			<table id='form'>
				<thead style="background-color:#c8c8f8">
					<tr>
						<td>
							ID
						</td>
						<td>
							Title
						</td>
						<td>
							Artist
						</td>
						<td>
							Release Date
						</td>
						<td>
							List Price
						</td>
						<td>
							Price
						</td>
						<td>
							Add to Cart
						</td>
					</tr>
				</thead>
				<c:forEach items='${results}'
						   var='CD'>
						   
					<tr>
						<td>
							${CD.id}
						</td>
						<td>
							${CD.title}
						</td>
						<td>
							${CD.artist}
						</td>
						<td>
							<fmt:formatDate value='${CD.releaseDate}' type='date' dateStyle='short'/>
						</td>
						<td>
							${CD.listPrice}
						</td>
						<td>
							${CD.price}
						</td>
						<td>
							<a href=
								"<c:url value='/cart'>
									<c:param name='itemID' value='${CD.id}'/>
								</c:url>">Add to Cart</a> 
						</td>
						
					</tr>
					
				
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>