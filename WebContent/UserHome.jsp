<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Screen</title>
</head>
<body>
<h1 align = "center">MAC FACILITY SYSTEM</h1>
<h3 align = "center">User Home Screen</h3>
<form action="/Mac_Facility/UserController" method="post">
<table>
<tr><td><a href = "/Mac_Facility/MARForm.jsp">Create MAR</a></td></tr>
<tr><td><a href = "/Mac_Facility/UpdateProfile.jsp">Update Profile</a></td></tr>
<tr><td><a href = "/Mac_Facility/MARList.jsp">Search MAR</a></td></tr>
<tr><td><a href = "/Mac_Facility/Index.jsp">Logout</a></td></tr>
</table>
</form>
</body>
</html>