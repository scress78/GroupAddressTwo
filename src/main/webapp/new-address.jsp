<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Address</title>
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
</style>
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