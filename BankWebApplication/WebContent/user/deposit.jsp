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
<body>
	<section>
		<nav>
			<jsp:include page="user_operation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Deposit</h1>
			
			<form action="user" method="post">
				<p>Account Number</p>
				<input type="text" name="accno" placeholder="Account No" required>
				<p>Balance</p>
				<input type="text" name="balance" placeholder="Balance" required>
				<input type="submit" name="op" value="deposit">
			</form>
		</article>
	</section>
</body>
</html>