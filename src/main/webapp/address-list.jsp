<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Current Addresses</title>
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
	<h1>Address List</h1>
	<form method = "post" action = "navigationServlet">
		
		<input type = "submit" value = "edit" name="doThisToItem">
		<input type = "submit" value = "delete" name="doThisToItem">
		<input type="submit" value = "add" name = "doThisToItem">
		
		<table>
		<tr>
			<td><h4>Name</h4></td>
			<td><h4>Address</h4></td>
		<tr>
			<c:forEach items="${requestScope.allItems}" var="currentitem">
			<tr>  
 			<td><input type="radio" name="id" value="${currentitem.id}"></td>
 			<td>${currentitem.name}</td>
 			<td>${currentitem.address}</td>
 			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>