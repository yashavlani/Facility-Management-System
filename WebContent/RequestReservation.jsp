<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<h1>Request Repair Reservation </h1>  
<form action="ViewReqReservation.jsp" method="post">  
<table>  
<tr>
<td>Start Date:</td>
<td><input type="date" name="stdate"></td>
</tr>  
<tr>
<td>Start Time:</td>
<td><input type="time" name="sttime"></td>
</tr>  
<tr>
<td>Facility Type:</td>
<td><input type="text" name="fctype" placeholder="Enter Facility Type"/></td>
</tr>  
<tr>
<td>Facility Name:</td>
<td><input type="text" name="fcname" placeholder="Enter Facility Name"/></td>
</tr>  
<tr><td colspan="2"><input type="submit" value="View"/></td></tr>  
</table>  
</form>  

<br>
<a href="Repairer_home.jsp">Back</a>