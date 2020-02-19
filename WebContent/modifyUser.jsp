<!-- modifyUser.jsp -->
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Change User Role</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
      <div class="logo"><h1><a href="/Mac_Facility">MAC Facility Management Application</a></h1></div>
      <div class="menu_nav">
  </div>
<input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
<tr>
	<td>
	<form action="/Mac_Facility/AdminController?action=modifyUser" method="post">
	<table style="width: 1200px; ">
	<tr>
	<tr>
  	<td> Username: </td>
 	<td> <input name="username" value="<c:out value='${User.username}'/>" type="text" maxlength="45">  </td>
 	<td> <input name="usernameError"  value="<c:out value='${errorMsgs.usernameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
 	<tr>
 	<td> New Role: </td>
<%--  	<td> <input name="role" value="<c:out value='${User.role}'/>" type="text" maxlength="45">  </td> --%>
 	<td><select name="role">
    <option value="user">user</option>
    <option value="repairer">repairer</option>
    <option value="facility_manager">facility_manager</option>
    <option value="admin">admin</option>
  </select></td>
  	<td> <input name="result" value="<c:out value='${result}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
  	<td> <input name="roleError"  value="<c:out value='${errorMsgs.roleError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
	</tr>
</table>
  <input type="submit" value="Submit">
	</form>      
</td>
</tr>
</table>
</body>
</html>