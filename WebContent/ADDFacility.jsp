<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserting New Facility</title>
</head>
<body>
<input name="errMsg"  value="<c:out value='${errorMsg.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="FacilityADD" action="/Mac_Facility/FacilityController?action=InsertFacility" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Facility ID (*): </td>
  <td> <input name="idfacility" value="<c:out value='${facility.idfacility}'/>" type="text" maxlength="30"> </td>
  	<td> <input name="FacilityIDError"  value="<c:out value='${errorMsg.getFacilityIDError()}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    
    </tr>

    <tr>
    <td> Facility Name (*): </td>
  
     <td> <input name="facility_name" value="<c:out value='${facility.facility_name}'/>" type="text" maxlength="30"> </td>
 	<td> <input name="FacilityNameError"  value="<c:out value='${errorMsg.getFacilityNameError()}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    
    </tr>
    <tr>
    <td> Interval: </td><td>
					<select name = "interval">
						<option value = "1 Hour">1 Hour</option>
						<option value = "2 Hour">2 Hour</option>
						<option value = "3 Hour">3 Hour</option>
					</select>
					</td>
     
  

    
    </tr>
	<tr>
    <td> Duration: </td>
   <td>
					<select name = "duration">
						<option value = "1 Hour">1 Hour</option>
						<option value = "Same Day">Same Day</option>
						<option value = "3 Hour">3 Hour</option>
					</select>
					</td>


    
    </tr>
    <tr>
    <td> Type (*): </td>
   <td>
		<select name = "Type">
			<option value = "Indoor">Indoor</option>
			<option value = "OutDoor">OutDoor</option>
		</select>
	</td>



    </tr>

    <tr>
    <td colspan="2">(*) Mandatory field</td>
    </tr>
    </table>
    <input name="action" value="ADDFacility" type="hidden">
    <input name ="action "type="submit" value=InsertFacility>
   
    </form>
</td>
</tr>
</table>

</body>
</html>