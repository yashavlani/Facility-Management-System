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
<h3 align = "center">Registration</h3>
<form action="/Mac_Facility/RegistrationController" method="post">
			<table style="with: 50%">
			<tr>
					<td>UserName (*):</td>
					<td><input type="text" name="username" /></td>
 					<td> <input name="usernameError" value="<c:out value='${errorMsgs.usernameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
					<tr>
					<td>Password (*):</td>
					<td><input type="password" name="password" /></td>
 					<td> <input name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>UTA ID (*):</td>
					<td><input type="text" name="uta_id" /></td>
 					<td> <input name="utaIDError" value="<c:out value='${errorMsgs.utaIDError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>First Name (*):</td>
					<td><input type="text" name="first_name" /></td>
 					<td> <input name="first_nameError" value="<c:out value='${errorMsgs.first_nameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Last Name (*):</td>
					<td><input type="text" name="last_name" /></td>
 					<td> <input name="last_nameError" value="<c:out value='${errorMsgs.last_nameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				
				<tr>
					<td>Address (*):</td>
					<td><input type="text" name="address" /></td>
 					<td> <input name="addressError" value="<c:out value='${errorMsgs.addressError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>City (*):</td>
					<td><input type="text" name="city" /></td>
 					<td> <input name="cityError" value="<c:out value='${errorMsgs.cityError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>State</td>
					<td>
					<select name = "states" required>
					<option value = "Texas">Texas</option>
					<option value = "Ohio">Ohio</option>
					<option value = "Florida">Florida</option>
					<option value = "Georgia">Georgia</option>
					<option value = "Michigan">Michigan</option>
					<option value = "Colorado">Colorado</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Zip Code (*):</td>
					<td><input type="number" name="zip_code" /></td>
 					<td> <input name="zipcodeError" value="<c:out value='${errorMsgs.zipcodeError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Email (*):</td>
					<td><input type="email" name="email" /></td>
 					<td> <input name="emailError" value="<c:out value='${errorMsgs.emailError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				<tr>
					<td>Role</td>
					<td>
					<select name = "roles" required>
					<option value = "user">User</option>
					<option value = "facility_manager">Facility Manager</option>
					<option value = "admin">Admin</option>
					<option value = "repairer">Repairer</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Contact No (*):</td>
					<td><input type="number" name="contact" /></td>
 					<td> <input name="contactError" value="<c:out value='${errorMsgs.contactError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr></table>
  			<input name="action" value="save_registration_details" type="hidden">
			<input type="submit" value="Submit" /></form>

</body>
</html>