<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Address Book</title>
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

<h1>Address Book By User Details</h1>
<!-- can possibly delete file!  view-address-book-details was used to troubleshoot this file and no longer has errors -->

<form method = "post" action = "listnavigationServlet">






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
      <input type = "submit" value = "edit" name="doThisToList">
	<input type = "submit" value = "delete" name="doThisToList">
	<input type="submit" value = "add" name = "doThisToList">

	<table>
		<c:forEach items="${requestScope.allLists}" var="currentlist">
			<tr>
			 <td><input type="radio" name="id" value="${currentlist.id}"></td>
			 <td><h2>${currentlist.listName}</h2></td>
			</tr>
			
			 <!-- commenting out to see whether jasper error can be resolved -->
			 <!-- <tr><td colspan="3">Date: ${currentlist.dateStamp}</td></tr> -->
			 
			 <tr><td colspan="3">Address Book User: ${currentlist.addressBookUser.userName}</td></tr>
			 
		 <c:forEach var = "listVal" items = "${currentlist.listOfItems}">
			 <tr><td></td>
			 <td colspan="3">${listVal.name}, ${listVal.address}
			 </td></tr> <!-- << are tags a little off here? extra td? -->
		 </c:forEach>
		
		</c:forEach>
	</table>

</form>


</body>
</html>
