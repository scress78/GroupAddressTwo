<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Existing Address</title>
</head>
<body>
	<form action = "editAddressServlet" method="post">
		Store: <input type ="text" name = "name" value= "${itemToEdit.name}">
		Item: <input type = "text" name = "address" value= "${itemToEdit.address}">
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Address">
	</form>
</body>
</html>