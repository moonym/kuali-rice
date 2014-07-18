<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core'
	prefix='c' %>
<%@ taglib uri="http://struts.apache.org/tags-html"
	prefix="html" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/sql'
	prefix='sql' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>

<sql:setDataSource dataSource="jdbc/CampusTrafficDataSource"/>
	<sql:query var="obstructions">
		SELECT * FROM Obstructions ORDER BY ID
	</sql:query>
	<sql:query var="parkingLots">
		SELECT * FROM ParkingLots ORDER BY Lot_Name
	</sql:query>
<html:html>
	<html:messages id="error" message="false"
		       header="errors.header" footer="errors.footer">
         <li>${error}</li>
     </html:messages>
	<table>
		<tr>
			<th colspan=4>Obstructions</th>
		</tr>
		<tr>
			<th>Street Name</th>
			<th>X Coordinate</th>
			<th>Y Coordinate</th>
			<th>Description</th>
		</tr>
		<c:forEach var='obstructions' begin='0' items='${obstructions.rows}'>
			<html:form action="/adminObstructions">
				<tr>
					<html:hidden property="ID" value="${obstructions.ID}"/>
					<td><html:text property="streetName" value="${obstructions.Street_Name}" size="15"/></td>
					<td><html:text property="xCoord" value="${obstructions.X_Coord}" size="10" maxlength="10"/></td>
					<td><html:text property="yCoord" value="${obstructions.Y_Coord}" size="10" maxlength="10"/></td>
					<td><html:text property="description" value="${obstructions.Description}" size="20" maxlength="80"/></td>
					<td><html:submit property="Edit" value="Edit" onclick="return confirm('Are you sure you want to submit?')"/></td>
					<td><html:submit property="Remove" value="Remove" onclick="return confirm('Are you sure you want to submit?')"/></td>
				</tr>
			</html:form>
		</c:forEach>
		<html:form action="/adminObstructions">
			<tr>
			 <td><html:text property="streetName" value="${old_streetName}" size="15"/></td>
			 <td><html:text property="xCoord" value="${old_xCoord}" size="10" maxlength="10"/></td>
			 <td><html:text property="yCoord" value="${old_yCoord}" size="10" maxlength="10"/></td>
			 <td><html:text property="description" value="${old_description}" size="20" maxlength="80"/></td>
			 <td><html:submit property="Add" value="Add" onclick="return confirm('Are you sure you want to submit?')"/></td>
			</tr>
		</html:form>
	</table>

	<table>
		<tr>
			<th colspan=6>Parking Lots</th>
		</tr>
		<tr>
			<th width="50px">Lot Name</th>
			<th width="80px">X Coordinate</th>
			<th width="80px">Y Coordinate</th>
			<th width="50px">Capacity</th>
			<th width="50px">Number Vehicles</th>
			<th width="50px">Lot Open?</th>
		</tr>
		<c:forEach var='parkingLot' begin='0' items='${parkingLots.rows}'>
			<html:form action="/adminParkingLots">
				<tr>
					<td><html:text property="lotName" value="${parkingLot.Lot_Name}" readonly="true" size="5"/></td>
					<td><html:text property="xCoord" value="${parkingLot.X_Coord}" readonly="true" size="10" maxlength="10"/></td>
					<td><html:text property="yCoord" value="${parkingLot.Y_Coord}" readonly="true" size="10" maxlength="10"/></td>
					<td><html:text property="capacity" value="${parkingLot.Capacity}" size="4" maxlength="4"/></td>
					<td><html:text property="vehicles" value="${parkingLot.Vehicles}" size="4" maxlength="4"/></td>
					<td><html:select property="lotOpen" value="${parkingLot.Lot_Open}">
						<html:option value="0">False</html:option>
						<html:option value="1">True</html:option>
					</html:select></td>
					<td><html:submit property="Edit" value="Edit" onclick="return confirm('Are you sure you want to submit?')"/></td>
				</tr>
			</html:form>
		</c:forEach>
	</table>
</html:html>
</body>
</html>