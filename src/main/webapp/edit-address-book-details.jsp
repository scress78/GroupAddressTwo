<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing Address Book</title>
</head>
<body>

<!-- needs styling -->

<h1>Edit Address Book: ${listToEdit.listName}</h1>
<!-- not previously attempted. Let's give it a try -->
<form action = "EditAddressBookDetailsServlet" method="post">
		<input type ="hidden" name = "id" value= "${listToEdit.id}">
			List Name: <input type ="text" name = "listName" value="${listToEdit.listName}"><br />
			
			Username: <input type = "text" name = "userName" value="${listToEdit.addressBookUser.userName}"><br />
		
		Available Items:<br />
		<select name="allItemsToAdd" multiple size="6">
			<c:forEach items = "${requestScope.allItems}" var="currentitem">
		 		<option value = "${currentitem.id}"> ${currentitem.name} | ${currentitem.address} </option>
			</c:forEach >
		</select><br />
		<input type = "submit" value="Edit List and Add Items">
	</form>
<a href = "index.html">Go add new items instead.</a>


</body>
</html>