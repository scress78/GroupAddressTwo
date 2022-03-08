<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing Address Book</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<style>

 *{
        box-sizing: border-box;
      }  

        h1{
      font-family: Brush Script MT;
      text-align: center;
      font-size: 500%;
      color:darkgreen;
        }
    
      body{
        font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        background-color: lightblue;
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
        color:burlywood;
      }
      
      .navbar .navbar-nav .nav-link:hover {
        color:darkgreen;
	}
	.navbar .navbar-nav .nav-link {
  		position: relative;
	}
	.navbar .navbar-nav .nav-link::after {
  		position: absolute;
  		bottom: 0;
  		left: 0;
  		right: 0;
  		margin: auto;
  		background-color: darkgreen;
 		color: transparent;
 		width: 0%;
  		content: '';
  		height: 3px;
  		transition: all 0.5s;
	}
	.navbar .navbar-nav .nav-link:hover::after {
  		width: 100%;
	}
	
	.element:hover{
      	color:#00A7DC;
      }
</style>

<body>
<h1>Edit Address Book: ${listToEdit.listName}</h1>
<!-- not previously attempted. Let's give it a try -->
<form action = "EditAddressBookDetailsServlet" method="post">
		<input type ="hidden" name = "id" value= "${listToEdit.id}">
			List Name: <input type ="text" name = "listName" value="${listToEdit.listName}" class="element"><br />
			
			Username: <input type = "text" name = "userName" value="${listToEdit.addressBookUser.userName}" class="element"><br />
			
			Date Stamp: <input type = "text" name = "dateStamp" value="${listToEdit.dateStamp}" class="element"><br />
		
		Available Items:<br />
		<!--Note here in particular requestScope appears to directly reference allItems! can be set as seen in
		    BookNavigationServlet.. note below how a list of addresses can also be handled
		      -->
		<select name="allItems" multiple size="6" class="element">
			<c:forEach items = "${requestScope.allItems}" var="currentitem">
		 		<option value = "${currentitem.id}"> ${currentitem.name} | ${currentitem.address} </option>
			</c:forEach >
		</select><br />
		
		<!--  previous way of doing things.. could select only addresses selected in previous addressBook
		Issue here being you can't ADD addresses, only subtract!
		<select name="allItemsToAdd" multiple size="6" class="element">
			<c:forEach items = "${listToEdit.listOfAddresses}" var="currentitem">
		 		<option value = "${currentitem.id}"> ${currentitem.name} | ${currentitem.address} </option>
			</c:forEach >
		</select><br />
		-->
		
		<input type = "submit" value="Edit List and Add Items" class="element">
	</form>
	
<a href="new-address.jsp">Go Add New Items Instead</a>
<a href="index.html">Home</a>


</body>
</html>