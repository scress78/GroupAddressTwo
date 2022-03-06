<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Books</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<style>

    
    *{
        box-sizing: border-box;
      }

       @font-face {
        font-family: brushScriptMT;
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
      
      h1:hover {
      	color: black;
      }
      
      c:hover {
      	color: black;
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

      
</style>

<body>
<!-- this one seems to be working great! -->

<h1>List of Current Address Books</h1>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: burlywood">
     
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler9"
            aria-controls="navbarToggler9" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarToggler9">
            <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Insert a New Item</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="addItemsForAddressDetailsServlet">Create a New List</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="viewAllAddressDetailsServlet">View all addresses in group</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="addItemsForAddressDetailsServlet">Create a new group</a>
                </li>   
                
                
            </ul>
        </div>
      </nav>

<form method = "post" action = "BookNavigationServlet">
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

	<input type = "submit" value = "edit" name="doThisToBook">
	<input type = "submit" value = "delete" name="doThisToBook">
	<input type="submit" value = "add" name = "doThisToBook"></br>
</form>



</body>
</html>