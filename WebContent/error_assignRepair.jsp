<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String userName = request.getParameter("userName");
String flag = request.getParameter("flag");
if(flag.equalsIgnoreCase("Day")){
	out.print("Already 5 Repairs Assigned To "+userName+" Of Today ");
}else if(flag.equalsIgnoreCase("Week")){
	out.print("Already 10 Repairs Assigned To "+userName+" Of Current Week ");
}else if(flag.equalsIgnoreCase("INMAR")){
	out.print("InComplete MAR ");
}else{
	out.print("Invalid Flag");
}



%>
</body>
</html>