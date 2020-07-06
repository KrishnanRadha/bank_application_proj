<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<link rel="stylesheet" type="text/css" href="css/formdesign.css"> 
<body bgcolor="cyan">
	<form action="admin" method="post">
		<article>
		 		<div class="frm">
					<h1>Admin Login Page</h1>
					<p>Name</p>
					<input type="text" name="name" placeholder="Name" required>
					<p>Password</p>
					<input type="password" name="password" placeholder="Password" required>
					<input type="submit" name="op" value="Admin_Login">
				</div>
		</article>
	</form>
</body>
</html>