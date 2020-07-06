<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifi Account</title>
</head>
<link rel="stylesheet" type="text/css" href="css/formdesign.css"> 
<link rel="stylesheet" type="text/css" href="css/layout.css"> 
<body>
	<section>
		<nav>
			<jsp:include page="admin_operation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Modify Customer Details</h1>
			<form action="admin" method="post">
				<p>Account Number</p>
				<input type="text" name="acNo" placeholder="Account Number" required>
				<p>Name</p>
				<input type="text" name="name" placeholder="Name" required>
				<p>Password</p>
				<input type="password" name="password" placeholder="Password" required>
				<p>Password</p>
				<input type="text" name="balance" placeholder="Balance" required>
				<input type="submit" name="op" value="modify_custemar_detailes">
				
			</form>
		</article>
	</section>

</body>
</html>