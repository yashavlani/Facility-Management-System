<!-- searchUser.jsp -->
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
  <div class="logo">
    <h1>
      <a href="/Mac_Facility">MAC Facility Management Application</a>
    </h1>
  </div>
  <div class="menu_nav"></div>
  <input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>"
    type="text"
    style="background-color: white; color: red; border: none; width: 800px"
    disabled="disabled">
  <table>
    <tr>
      <td>
        <form action="/Mac_Facility/AdminController?action=searchUser"
          method="post">
          <table style="width: 1200px;">
            <tr>
            <tr>
              <td>User Last name:</td>
              <td><input id = "user_last_name" name="user_last_name" value="<c:out value='${User.last_name}'/>" type="text" maxlength="45"></td>
              <td><input name="lastNameError" value="<c:out value='${errorMsgs.lastNameError}'/>" type="text" style="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"></td>
            </tr>
          </table>
          <input type="submit" id="submit" value="Submit">
        </form>
      </td>
    </tr>
  </table>
</body>
</html>