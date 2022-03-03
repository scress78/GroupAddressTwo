<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Address Book</title>
</head>
<body>

	<!-- Not yet implemented! -->
	<form action = "CreateNewAddressBookServlet" method="post">
		<!-- Implemented via AddressBookDetail.java as AddressBookName  -->
		Address Book Name: <input type ="text" name = "addressBookName"><br />
		
		<!-- Implemented via AddressBookUser.java as AddressBookUser  -->
		Username: <input type = "text" name = "userName"><br />
		
		<!-- all properties from Address.java -->
		<!--  not quite working yet, needs troubleshoot! fix was taglib at top! Must be added-->			
		Available Addresses:<br />
		<!-- Multiple size = how many can be in the list! -->
		<select name="allItemsToAdd" multiple size="6">
			<c:forEach items = "${requestScope.allItems}" var="currentitem">
		 		<option value = "${currentitem.id}"> ${currentitem.name} | ${currentitem.address} </option>
			</c:forEach >
		</select> <br />
		
		<input type = "submit" value="Create Book and Add Addresses">
	</form>
	<a href = "index.html">Go add new address items instead.</a>

</body>
</html>