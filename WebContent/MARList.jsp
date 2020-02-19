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
<h3 align = "center">View MAR List</h3>

<form action="/Mac_Facility/UserController?action=searchMar" method="get">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 20px; ">Select MAR</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">MAR</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Facility Type</th>
				<th class="myTableHead" style="padding-right: 35px; text-align: left">Facility Name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Description</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Date</th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Time</th> 
			</tr>

 		<c:forEach items="${mform_list}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 20px; text-align: center"><input type="radio" id="radioCompany${status.count}" name="radioCompany" value="${status.count}"></td> 	
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.mar}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facility_type}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.facility_name}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.description}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.strDate}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.strTime}" /></td>
            <td> <a href="/Mac_Facility/UserController?action=searchspecificMar&id=${status.count}">View</a></td>
			</tr>
		</c:forEach>
 </table>
 <input name="action" value="searchMar" type="hidden">
			<input align = "center" type="submit" value="Submit" />			
 </form>
</body>
</html>