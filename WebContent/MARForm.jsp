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
<h1 align = "center">MAC FACILITY SYSTEM</h1>
<h3 align = "center">MAR Form</h3>
<form action="/Mac_Facility/UserController?action=save_mar_details" method="post">
			<table style="with: 50%">
			<tr>
					<td>Facility Type(*):</td>
					<td>
					<select name = "facility_type" required>
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
					</select>
					</td>				
			</tr>
					<tr>
					<td>Facility Name(*):</td>
					<td>
					<select name = "facility_name">
					<option value = "MR1">MR1</option>
					<option value = "MR2">MR2</option>
					<option value = "MR3">MR3</option>
					<option value = "MR4">MR4</option>
					</select>
					</td>
					</tr>

				<tr>
					<td>Description(*):</td>
					<td><input type="text" name="description" /></td>
 					<td> <input name="descriptionError" value="<c:out value='${mferrorMsgs.descriptionError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				</table>
				
			<input type="submit" value="Submit" /></form>
</body>
</html>