<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Reported problems</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" type="text/css" href="advse.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/resources/demos/style.css">
</head>

<body>
	<div class="container">
		<center>
			<h2>MAC FACILITY SYSTEM</h2>
		</center>
		
		<h4> Facility Manager page</h4>

		
		<div class="text-l"></div><br>
		<form action="MARController?action=searchMAR" method="post">
			<br><br>
			<input type="hidden" name="username" value="<c:out value='${username}'/>">
			
			<label for="search"><b>MAR number:</b></label><br>
			<input type="text" name="idx" placeholder="Enter MAR number" size="40px"><br>

			<label for="date"><b>Date:</b></label>
			<input type="date" name="assigndate" value="<c:out value='${today}'/>"><br>

			<label for="time"><b>Time:</b></label>
			<select name="assigntime">
				<c:forEach items="${now}" var="item" varStatus="status">
					<option <c:out value='${item.value}'/>><c:out value='${item.key}'/></option>
				</c:forEach>
			</select><br>

			<label for="facility type"><b>Facility type:</b></label>
			<select name="facilitytype">
				<option></option>
				
				<c:forEach items="${types}" var="item" varStatus="status">
					<option <c:out value='${item.value}'/> value="<c:out value='${item.key.master}'/>"><c:out value='${item.key.venue}'/></option>
				</c:forEach>
			</select><br>
	
			<label for="facility name"><b>Facility name:</b></label>
			<select name="facilityname">
				<option></option>
				
				<c:forEach items="${names}" var="item" varStatus="status">
					<option <c:out value='${item.value}'/>><c:out value='${item.key}'/></option>
				</c:forEach>
			</select><br>
			
			<label for="assigned to"><b>Assigned to:</b></label>
			<select name="repairer">
				<option></option>
				
				<c:forEach items="${repairers}" var="item" varStatus="status">
					<option <c:out value='${item.value}'/>><c:out value='${item.key}'/></option>
				</c:forEach>
			</select><br>

			<center>
				<button type="submit" >
					<b>Search</b>
				</button>
			</center><br><br>
			<hr>
		</form>
	</div>
</body>
</html>