<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Books</title>
</head>
<body>
<!-- this one seems to be working great! -->

<h1>List of Current Address Books</h1>

<form method = "post" action = "listnavigationServlet">
	<c:forEach items="${requestScope.allLists}" var="currentlist">
		<tr>
			 <td><input type="radio" name="id" value="${currentlist.id}"></td>
			 <td><h2>List Name: ${currentlist.listName}</h2></td>
		</tr>
		
		<tr>
			<td colspan="3">Address Book User: ${currentlist.addressBookUser.userName}  Date Initialized: ${currentlist.dateStamp}</td>
		</tr></br>
		
		<tr>
			<td>Addresses In Book:</td>
		</tr>
		
		<tr>
			<c:forEach var = "listVal" items = "${currentlist.listOfAddresses}">
				<tr>
					<td></td>
					<td colspan="3">${listVal.name}, ${listVal.address}</td>
				</tr></br>
			</c:forEach>
		</tr>
	
	</c:forEach></br>

	<input type = "submit" value = "edit" name="doThisToList">
	<input type = "submit" value = "delete" name="doThisToList">
	<input type="submit" value = "add" name = "doThisToList"></br>
</form>

<a href="addItemsForAddressDetailsServlet">Create a new List</a></br>
<a href="index.html">Insert a new item</a></br>
<a href="viewAllAddressDetailsServlet">View all addresses in group</a> <br />
<a href="addItemsForAddressDetailsServlet">Create a new group</a>

</body>
</html>