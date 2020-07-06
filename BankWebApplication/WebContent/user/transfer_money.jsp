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
			<h1>Transfer money</h1>
			
			<form action="user" method="post">
				<p>ATM Pin</p>
				<input type="password" name="pin" placeholder="ATM Pin" required>
				<p>Transfer account No</p>
				<input type="text" name="tAcno" placeholder="Account No" required>
				<p>Balance</p>
				<input type="text" name="balance" placeholder="Balance" required>
				<input type="submit" name="op" value="transfer_money">
			</form>
		</article>
	</section>
</body>
</html>