<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>set/update pin</title>
</head>
<link rel="stylesheet" type="text/css" href="css/formdesign.css"> 
<link rel="stylesheet" type="text/css" href="css/layout.css"> 
<body>
	<section>
		<nav>
			<jsp:include page="user_operation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Set/Update Pin</h1>
			
			<form action="user" method="post">
				<p>Enter ATM Pin</p>
				<input type="password" name="pin" placeholder="ATM Pin" required>
				<input type="submit" name="op" value="set_pin">
			</form>
		</article>
	</section>
</body>
</html>