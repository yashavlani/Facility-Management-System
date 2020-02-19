<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Repairer Manager Homepage</title>
</head>
<body>
	<div class="main">
		<div class="header">
			<div class="header_resize">

				<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->

				<h1 align="center">MAC FACILITY SYSTEM</h1>
				<h3 align="center">Repairer Home Screen</h3>
				<div class="content">

					<div class="menu_nav">
						<ul>
							<li><a href="RepairerController?action=viewAssignedRepairs" target="_top"><span>View
										My Assigned Repairs</span></a></li>
							<li><a href="RepairerController?action=requestReservation" target="_top"><span>Request
										Reservation</span></a></li>
							<li><a href="RepairerController?action=modifyReservedRepairs" target="_top"><span>modify
										my reserved repairs</span></a></li>
							<li><a href="RepairerController?action=cancelReservedRepairs" target="_top"><span>cancel
										my reserved repairs</span></a></li>
							<li><a href="Index.jsp" target="_top"><span>Logout</span></a></li>

						</ul>
						<br></br>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>