<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Address</title>
</head>
<body>
	<h1>Add A New Address Here</h1>
	
	<h2>Add New Address Item</h2>
	<form action = "CreateNewAddressServlet" method="post">
		
		Name: <input type ="text" name = "name"> *(Enter Name of Person or Business)<br><br>
		Street Address: <input type = "text" name = "address"><br><br>
		<input type = "submit" value="Add Address">
	</form> <br />

</body>
</html>