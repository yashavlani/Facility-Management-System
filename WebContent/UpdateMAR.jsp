<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update MAR</title>
</head>
<body>
<h1 align = "center">MAC FACILITY SYSTEM</h1>
<h3 align = "center">MAR Form</h3>
<form action="/Mac_Facility/FacilityController?action=updateMAR" method="post">
			<table style="with: 50%">
			<tr>
					<td>Facility (*):</td>
					<td>
					<select name = "facility" required>
					<%--
					<option value = "Multipurpose_rooms">Multipurpose rooms</option>
					<option value = "5_Indoor_basketball_courts">5 Indoor basketball courts</option>
					<option value = "9_Volleyball_courts">9 Volleyball courts</option>
					<option value = "Indoor_soccer_gymnasium">Indoor soccer gymnasium</option>
					<option value = "5_Racquetball_courts">5 Racquetball courts</option>
					<option value = "10_Badminton_courts">10 Badminton courts</option>
					<option value = "Table_Tennis">Table Tennis</option>
					<option value = "Conference_rooms">Conference rooms</option>
					<option value = "2_Outdoor_Volleyball_Courts">2 Outdoor Volleyball Courts</option>
					<option value = "2_Outdoor_Basketball_Courts">2 Outdoor Basketball Courts</option>
					--%>
					<c:forEach items="${marList}" var="mar">
					    	<option value="${mar}">
					        	${mar}
					    	</option>
					  	</c:forEach>
					</select>
					</td>				
			</tr>
				
				<tr>
					<td>Urgency (*):</td>
					<td>
					<select name = "urgency">
						<option value = "high">High</option>
						<option value = "low">Low</option>
						<option value = "medium">Medium</option>
					</select>
					</td>
				</tr>
				
				<tr>
					<td>Estimated Time(*):</td>
					<td>
					<select name = "time">
						<option value = "1 Hour">1 Hour</option>
						<option value = "1:30 Hour">1 Hour:30 mins</option>
						<option value = "2 Hour">2 Hour</option>
						<option value = "3 Hour">3 Hour</option>
					</select>
					</td>
				</tr>
				
			</table>
			<input type="submit" value="updateMAR" /></form>

</body>
</html>