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
<form action="/Mac_Facility/UserController?action=createMar" method="get">
<input type="submit" value="Create MAR" />
			<select name="Mform2">
  					<c:forEach items="${listFacility}" var="Mform2">
       						<option value="${Mform2.facility_type1}">${Mform2.facility_type1}</option>
   					</c:forEach>
			</select>
									<input name="action" value="createMar" type="hidden">
						
						</form>
<form action="/Mac_Facility/UserController?action=SendFacilityType&facility=${Mform2.facility_type1}" method="post">
			
<input type="submit" value="SendFacilityType" />
</form>
			
				<table style="with: 50%">
					<tr>
					<td>Description(*):</td>
					<td><input type="text" name="description" /></td>
 					<td> <input name="descriptionError" value="<c:out value='${mferrorMsgs.descriptionError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				</table>
</body>
</html>