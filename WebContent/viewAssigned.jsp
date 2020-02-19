<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	
</head>

<body>
<input name="errMsg"  value="<c:out value='${errorMsg.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
	<div class="container">
		<center>
		<h1>VIEW ASSIGNED MARS</h1>
			<h2>UTA Mac Facility Maintenance </h2>
		</center>
		


		<table  border="1" class="myTable">
				<tr>
					<td>Date:</td>
					<td>
						<form action="/Mac_Facility/FacilityController?action=DatedMAR" method="post">
							<input type="date" name="date" value = ""/>
							<button type="submit" value="datedMAR"> SEARCH DATED MAR </button>
						</form>
					</td>
					<td>Type:</td>
					<td>
						<form action="/Mac_Facility/FacilityController?action=typeMAR" method="post">
							<input type="text" name="type" value = ""/>

							<button type="submit" value="searchByMAR"> SEARCH TYPE MAR </button>
						</form>
					</td>
				</tr>
				<tr>
				
				</tr>
			<tr class="myTablerow">
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility type</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Name</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Urgency</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Description</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Reported By</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Report Date</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">MAR number</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Assigned to</th>
			
				<th class="myTableHead" style="padding-right: 20px; text-align: left" >Estimate of repair</th>
				
			</tr>
			
			<c:forEach items="${MARS}" var="item" varStatus="status">
			<tr class="myTablerow">
				<form action="FacilityController?action=searchAssignedMAR" method="post">
					<td><c:out value='${item.getFacility_type()}'/></td>
					<td><c:out value='${item.getFacility_name()}'/></td>
					<td><c:out value='${item.getUrgency()}'/></td>
					<td><c:out value='${item.getDescription()}'/></td>
					<td><c:out value='${item.getReportedBy()}'/></td>
					<td><c:out value='${item.getDate()}'/></td>
					<td><c:out value='${item.getMar()}'/></td>
					<td><c:out value='${item.getAssigned_to()}'/></td>
					 <td><c:out value='${item.getTime()}'/></td>
					<td></td>
				</form>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>