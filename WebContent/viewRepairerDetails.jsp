<%@page import="MAC_Facility.model.Repairer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Repairer Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
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

				<!-- <form action="/Mac_Facility/RepairerDetailController" method="get">
					<input type="submit" class="btn btn-primary col-md-3" role="button"
						value="View Details">

				</form> -->

				<div class="content">

					<table border="1" class="myTable">
						<tr class="myTableRow">
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
								style="padding-right: 10px; text-align: center">Description</th>
								<th class="myTableHead"
								style="padding-right: 10px; text-align: center">Wing</th>

						</tr>

						<tbody>
							<c:forEach items="${repairerLists}" var="mar" varStatus="status">
								<tr>
								
									<td><c:out value="${mar.facility_type}" /></td>
									<td><c:out value="${mar.facility_name}" /></td>
									<td><c:out value="${mar.startDate}" /></td>
									<td><c:out value="${mar.startTime}" /></td>
									<td><c:out value="${mar.floor}" /></td>
									<td>C</td>

								</tr>
							</c:forEach>
						</tbody>

						<%-- 	<td><a href="/Mac_Facility/viewRepairerDetails.jsp?userId=${repairer.id}"><div style="height:100%;width:100%"><c:out value="${repairer.id}" /></div></a></td>
			<td class="myTableCell" style="padding-right: 10px; text-align: center""><c:out value="${repairer.facility_type}" /></td>
			<td class="myTableCell" style="padding-right: 10px; text-align: center""><c:out value="${repairer.facility_name}" /></td>
			<td class="myTableCell" style="padding-right: 10px; text-align: center""><c:out value="${repairer.startDate}" /></td>
			<td class="myTableCell" style="padding-right: 10px; text-align: center""><c:out value="${repairer.startTime}" /></td>
			<td class="myTableCell" style="padding-right: 10px; text-align: center""><c:out value="${repairer.floor}" /></td> --%>



						</c>


					</table>

					<br>
				<!-- 	<br> <br> <a href="RequestReservation.jsp">Request
						Reservation</a> -->


					<%-- <h1>Displaying Student List</h1> 
      <table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Student Name</b></th> 
          <th><b>Student Age</b></th> 
          <th><b>Course Undertaken</b></th> 
         </tr> 
        Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
         
        <%ArrayList<Repairer> std = (ArrayList<Repairer>)request.getAttribute("habits"); %>
        <% System.out.println(std);%>
        <% for(Repairer s:std){%> 
      
            <tr> 
                <td><c:out value="${s.getFacility_name()}" /></td> 
                <td><c:out value="${s.getFacility_name()}" /></td> 
                <td><c:out value="${s.getFacility_name()}" /></td> 
            </tr> 
        <%}%> 
        </table>       --%>

				</div>
			</div>
		</div>
	</div>
</body>
</html>