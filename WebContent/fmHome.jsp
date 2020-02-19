<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Facility Manager Homepage</title>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">

<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->

      <div class="logo"><h1><a href="<c:url value='/' />">Maverick Management</a></h1></div>
  <div class="content">  

      <div class="menu_nav">
        <ul>
          <li><a href="/Mac_Facility/FacilityController?action=listfacilities" name="List Facilities" target="_top"><span>List Facilities</span></a></li>
          <li><a href="/Mac_Facility/FacilityController?action=listfacilities" name="Facilities Available" target="_top"><span>Facilities Available</span></a></li>  
          <li><a href="/Mac_Facility/FacilityController?action=searchMAR" name="Search MAR" target="_top"><span>Search MAR</span></a></li>  
          <li><a href="/Mac_Facility/FacilityController?action=searchAssignedMAR" name="Search Assigned MAR" target="_top"><span>Search Assigned MAR</span></a></li>
          <li><a href="/Mac_Facility/FacilityController?action=ADDFacility" name="ADD Facility"  target="_top"><span>ADD Facility</span></a></li> 
           <li><a href="/Mac_Facility/FacilityController?action=assignMAR" name="Assign Repairer"  target="_top"><span>Assign Repairer</span></a></li> 
            <li><a href="UpdateMAR.jsp" name="Update MAR" target="_top"><span>Update MAR</span></a></li> 
          
        </ul>
        <br></br> 
        <button> <a href="main.jsp" name="Logout"  target="_top">LOGOUT</a></button>
      </div>
    </div>
  </div>
  </div>
  </div>

</body>
</html>