<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	
</head>

<body>
	<div class="container">
		<center>
		<h1>VIEW UNASSIGNED MARS</h1>
			<h2>UTA Mac Facility Maintenance </h2>
		</center>
	
		<td>MAR:</td>
					<td>
						<form action="/Mac_Facility/FacilityController?action=searchByMAR" method="post">
							<input name="newmar">
							<button type="submit" value="MAR"> SEARCH MAR </button>
						</form>
					</td>
		<table  border="1" class="myTable">
			<tr class="myTablerow">
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility type</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Name</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Description</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Reported By</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Report Date</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">MAR number</th>
			
			</tr>
			
			<c:forEach items="${MARS}" var="item" varStatus="status">
			<tr class="myTablerow">
				<form action="FacilityController?action=searchMAR" method="post">
					<td><c:out value='${item.getFacility_type()}'/></td>
					<td><c:out value='${item.getFacility_name()}'/></td>
					<td><c:out value='${item.getDescription()}'/></td>
					<td><c:out value='${item.getReportedBy()}'/></td>
					<td><c:out value='${item.getDate()}'/></td>
					<td><c:out value='${item.getMar()}'/></td>
				
					<td></td>
				</form>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>