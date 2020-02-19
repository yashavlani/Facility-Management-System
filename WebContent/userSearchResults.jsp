<!-- userSearchResults.jsp -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Users List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
	<div class="logo">
		<h1>
			<a href="/Mac_Facility">MAC Facility Management Application</a>
		</h1>
	</div>

	<!-- change -->
	<form action="/MAC_Facility/AdminController" method="post">
		<table border="1" class="myTable">
			<tr class="myTableRow">
				<th class="myTableHead"
					style="padding-right: 20px; text-align: left">User name</th>
				<th class="myTableHead"
					style="padding-right: 20px; text-align: left">First Name</th>
				<th class="myTableHead"
					style="padding-right: 20px; text-align: left">Last Name</th>
				<th class="myTableHead"
					style="padding-right: 35px; text-align: left">Phone</th>
				<th class="myTableHead"
					style="padding-right: 30px; text-align: left">Email</th>
				<th class="myTableHead"
					style="padding-right: 30px; text-align: left">Role</th>
			</tr>

			<c:forEach items="${USERS}" var="item" varStatus="status">
				<tr class="myTableRow">
					<td class="myTableCell" style="padding-right: 20px;"><c:out
							value="${item.getUser_name()}" /></td>
					<td class="myTableCell" style="padding-right: 20px;"><c:out
							value="${item.getfirst_Name()}" /></td>
					<td class="myTableCell" style="padding-right: 20px;"><c:out
							value="${item.getlastName()}" /></td>
					<td class="myTableCell" style="padding-right: 35px;"><c:out
							value="${item.getPhone()}" /></td>
					<td class="myTableCell" style="padding-right: 30px;"><c:out
							value="${item.getEmail()}" /></td>
					<td class="myTableCell" style="padding-right: 30px;"><c:out
							value="${item.getUserRole()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>