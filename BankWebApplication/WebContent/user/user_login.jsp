<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/formdesign.css"> 
<body bgcolor="cyan">
	<form action="user" method="post">
		<article>
		 		<div class="frm">
					<h1>User Login Page</h1>
					
					<p>Name</p>
					<input type="text" name="name" placeholder="Name" required>
					
					<p>Password</p>
					<input type="password" name="password" placeholder="Password" required>
					
					<input type="submit" name="op" value="User_Login">
				</div>
		</article>
	</form>
</body>
</html>