<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MAR Form</title>
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsg.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<h1 align = "center">MAC FACILITY SYSTEM</h1>
<h3 align = "center">MAR Form</h3>
<form action="/Mac_Facility/FacilityController?action=assignRepairer" method="post">
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
					<td>AssignedTo(*):</td>
					<td>
					<select name = "repairer">
						<c:forEach items="${repairerList}" var="repairer">
					    	<option value="${repairer}">
					        	${repairer}
					    	</option>
					  	</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>Date(*):</td>
					<td><input name="date" value=""></td>
					<td> <input name="DateError"  value="<c:out value='${errorMsg.getDateError()}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
				
				</tr>
				
				

				</table>
  			<input name="action" value="assignRepairer" type="hidden">
			<input type="submit" value="assignRepairer" /></form>

</body>
</html>