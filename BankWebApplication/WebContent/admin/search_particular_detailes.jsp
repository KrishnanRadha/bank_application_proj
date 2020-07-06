<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Particular Account detail</title>
</head>
<body>
	<section>
		<nav>
			<jsp:include page="admin_operation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Search Particular Account detail</h1>
			<form action="admin" method="post">
				<p>Account Number</p>
				<input type="text" name="acNo" placeholder="Account Number" required>
				<input type="submit" name="op" value="search_account_detailes">
			</form>
		</article>
	</section>
	

</body>
</html>