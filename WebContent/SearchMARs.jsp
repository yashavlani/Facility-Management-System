<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h1 align = "center">MAC FACILITY SYSTEM</h1>
<h3 align = "center">Search MARs</h3>
<form action="/Mac_Facility/FacilityManagerController" method="post">
			<table style="with: 50%">
			<tr>
					<td>Start Date:</td>
					<td><input type="date" name="start_date" value="2019-09-17" /></td>
 					<!-- td> <input name="usernameError" value="<c:out value='${errorMsgs.usernameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td-->
				</tr>
					<tr>
					<td>Start Time:</td>
					<td><input type="time" name="start_time" value="17:00" /></td>
 					<!--td> <input name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td-->
				</tr>
				<tr>
					<td>Facility Type:</td>
					<select  name = "facility_type">
					  <option value="Multipurpose_rooms" selected>Multipurpose rooms</option>
					  <option value="5_Indoor_basketball_courts">5 Indoor basketball courts</option>
					  <option value="9_Volleyball_courts">9 Volleyball courts</option>
					</select>
				</tr>
				<tr>
					<td>Facility Name:</td>
					<select name = "facility_name">
					  <option value="" selected></option>
					  <option value="MR1">MR1</option>
					  <option value="MR2">MR2</option>
					  <option value="MR3">MR3</option>
					  <option value="MR4">MR4</option>
					</select>
				</tr>
				<tr>
					<td>Assigned To:</td>
					</tr>
				
				<tr>
					<td>MAR Number:</td>
					</tr>
					</table>
  			<input name="action" value="search_mars" type="hidden">
			<input type="submit" value="Submit" /></form>

</body>
</html>