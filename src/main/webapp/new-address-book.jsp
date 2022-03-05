<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Address Book</title>
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
<h1>Create New Address Book</h1>

	<nav class="navbar navbar-expand-lg navbar-light" style="background-color: burlywood">
     
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler9"
            aria-controls="navbarToggler9" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarToggler9">
            <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="index.html">Go Add New Address Items Instead</a>
                </li>
            </ul>
           </div>
          </nav>
	<!--  possible this is done already -->
	<!-- See if the link for CREATE NEW ADDRESS BOOK IS WHAT WE'RE LOOKING FOR HERE-->


	<!-- Not yet implemented! -->
	<form action = "CreateNewAddressBookServlet" method="post">
		<!-- Implemented via AddressBookDetail.java as AddressBookName  -->
		<h4>Address Book Name: <input type ="text" name = "addressBookName"></h4><br />
		
		<!-- Implemented via AddressBookUser.java as AddressBookUser  -->
		<h4>User name:        <input type = "text" name = "userName"></h4><br />
		
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
	

</body>
</html>