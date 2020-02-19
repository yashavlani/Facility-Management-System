<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FACILITIES AVAILABLE</title>
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">

        <div class="header_resize">
      <div class="logo"><h1><a href="/MAC_Facility">MAVERICK ACTIVITY CENTER</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

     <div class="mainbar"><div class="submb"></div></div>
     
      
      <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 130px; ">Facility</th>
				<th class="myTableHead" style="width: 130px; ">Name</th> 
				<th class="myTableHead" style="width: 105px; ">Duration</th>
				<th class="myTableHead" style="width: 105px; ">Interval</th>
				<th class="myTableHead" style="width: 74px;  ">Type</th>
			</tr>
			<c:forEach items="${FACILITIES}" var="item" varStatus="status">
			<tr class="myTableRow">
				
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.getidfacility()}" /></td>
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.getfacility_name()}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.getDuration()}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.getInterval()}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.getType()}" /></td>
           
			</tr>
		</c:forEach>
</table>
    

</body>
</html>