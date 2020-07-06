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
			<h1>Change Password</h1>
			
			<form action="user" method="post">
				<p>Old Password</p>
				<input type="password" name="oldPass" placeholder="Old Password" required>
				<p>New Password</p>
				<input type="password" name="newPass" placeholder="New Password" required>
				<input type="submit" name="op" value="change_password">
			</form>
		</article>
	</section>
</body>
</html>