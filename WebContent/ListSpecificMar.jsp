<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MAR Details</title>
</head>
<body>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${MAR.facility_type}" /> </td>
    </tr>

    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${MAR.facility_name}"/> </td>
    </tr>

    <tr>
    <td> MAR Decscription: </td>
    <td> <c:out value="${MAR.description}" /> </td>
    </tr>

    <tr>
    <td> Reported By: </td>
    <td> <c:out value="${MAR.strDate}" /> </td>
    </tr>
    
     <tr>
    <td> Reported By: </td>
    <td> <c:out value="${MAR.strTime}" /> </td>
    </tr>

    <tr>
    </tr>
    </table>
</td>
</tr>
</table>
</body>
</html>