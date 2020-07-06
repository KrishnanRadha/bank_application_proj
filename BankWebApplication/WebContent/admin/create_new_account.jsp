<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/formdesign.css"> 
<link rel="stylesheet" type="text/css" href="css/layout.css"> 

<body bgcolor="cyan">
	<section>
		<nav>
			<jsp:include page="admin_operation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Add new Account</h1>
			<form action="admin" method="post">
				<p>Account Number</p>
				<input type="text" name="acNo" placeholder="Account Number" required>
				<p>Name</p>
				<input type="text" name="name" placeholder="Name" required>
				<p>Password</p>
				<input type="password" name="password" placeholder="Name" required>
				<input type="submit" name="op" value="Add_Account">
			</form>
		</article>
	</section>
	
</body>
</html>