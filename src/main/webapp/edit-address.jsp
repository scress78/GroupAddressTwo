<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Existing Address</title>
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
      
	}
</style>


<body>
<h1>Edit an Existing Address</h1>
	<form action = "editAddressServlet" method="post">
		<h4>Store: <input type ="text" name = "name" value= "${itemToEdit.name}"></h4><br>
		<h4>Item:  <input type = "text" name = "address" value= "${itemToEdit.address}"></h4><br>
		<input type = "hidden" name = "id" value="${itemToEdit.id}">
		<input type = "submit" value="Save Edited Address">
	</form>
</body>
</html>