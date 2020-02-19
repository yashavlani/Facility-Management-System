<%@page import="MAC_Facility.model.Repairer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Repairer Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<h1>Modify</h1>
</head>
<body>
	<div class="main">
		<div class="header">
			<div class="header_resize">

				<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->


				<div class="logo">
					<h1>
						<a href="<c:url value='/Repairer_home.jsp' />"> Repairer Home</a>
					</h1>
				</div>

				<div class="content">

					<table border="1" class="myTable">
						<tr class="myTableRow">
							<th class="myTableHead"
								style="padding-right: 10px; text-align: center">ID</th>
							<th class="myTableHead"
								style="padding-right: 10px; text-align: center">Facility
								Type</th>
							<th class="myTableHead"
								style="padding-right: 10px; text-align: center">Facility
								Name</th>
							<th class="myTableHead"
								style="padding-right: 10px; text-align: center">Start Date</th>
							<th class="myTableHead"
								style="padding-right: 10px; text-align: center">Start Time</th>
							<th class="myTableHead"
								style="padding-right: 10px; text-align: center">Modify</th>


						</tr>

						<tbody>
							<c:forEach items="${repairerList}" var="mar" varStatus="status">
								<tr>
								<form
											action="/Mac_Facility/RepairerController?action=modifyReservation&id=${mar.id}"
											method="post">

									<td><c:out value="${mar.id}" /></td>
									<td><c:out value="${mar.facility_type}" /></td>
									<td><c:out value="${mar.facility_name}" /></td>
									<td><c:out value="${mar.startDate}" /></td>
									<td><input type="text" name="startTime123"
										value=<c:out value="${mar.startTime}" />></td>
									<td>
											<button type="submit" name="your_name" value="your_value"
												class="btn-link">Modify</button>
										</td>
									</form>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<br>
					<input name="resultModify" value="<c:out value='${resultModify}'/>"
						type="text"
						style="background-color: white; color: red; border: none; width: 800px"
						disabled="disabled" maxlength="60">
				</div>
			</div>
		</div>
	</div>
</body>
</html>