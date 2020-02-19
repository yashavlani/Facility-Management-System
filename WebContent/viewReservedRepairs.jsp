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
</head>
<h1>View Reserved Repairs</h1>
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

						</tr>

						<tbody>
							<c:forEach items="${repairerList}" var="mar" varStatus="status">
								<tr>
									<td>
										<!-- <a href="/Mac_Facility/viewRepairerDetails.jsp?userId=${mar.id}"> -->
										<a
										href='RepairerController?repairId=${mar.id}&action=viewRepairDetails'>
											<div style="height: 100%; width: 100%">
												<c:out value="${mar.id}" />
											</div>
									</a>
									</td>
									<td><c:out value="${mar.facility_type}" /></td>
									<td><c:out value="${mar.facility_name}" /></td>
									<td><c:out value="${mar.startDate}" /></td>
									<td><c:out value="${mar.startTime}" /></td>
								</tr>
							</c:forEach>
						</tbody>
				</div>
			</div>
		</div>
	</div>
</body>
</html>