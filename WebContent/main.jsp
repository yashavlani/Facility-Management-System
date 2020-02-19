<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1 align = "center">MAC FACILITY SYSTEM</h1>
<h3 align = "center">Login</h3>
<form action="/Mac_Facility/LoginController" method="post">
<input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">

			<table style="with: 50%">
			<tr>
					<td align = "center">UserName</td>
					<td align = "center"><input type="text" name="username" /></td>
 					<td><input name="usernameError" value="<c:out value='${errorMsgs.usernameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
					<tr>
					<td align = "center">Password</td>
					<td align = "center"><input type="password" name="password" /></td>
 					<td> <input name="passwordError" value="<c:out value='${errorMsgs.passwordError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
				</tr>
				</table>
  			<input name="action" value="login" type="hidden">
			<input align = "center" type="submit" value="Submit" /></form>
			<a href = "/Mac_Facility/Registration.jsp" >Create a new Account</a>

</body>
</html>