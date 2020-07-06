<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/table_design.css"> 
<body>
	<section>
		<nav>
			<jsp:include page="admin_operation.jsp"></jsp:include>
		</nav>
		<article>
			<c:if test="${op=='Add_Account'}">
				<h1><c:out value="Sucessfully Account Added"></c:out></h1>
			</c:if>
			<c:if test="${op=='search_account_detailes'}">
				<table id="customers">
					<tr>
						<th>Account Number</th>
						<th>Name</th>
						<th>Balance</th>
					</tr>
					<tr>
						<td><c:out value="${c.getAccno()}"></c:out></td>
						<td><c:out value="${c.getName()}"></c:out></td>
						<td><c:out value="${c.getBalance()}"></c:out></td>
					</tr>
				</table>
			</c:if>
			
			<c:if test="${op=='modify_custemar_detailes'}">
				<h1><c:out value="Sucessfully Account modified"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='balance_inquiry'}">
				<table id="customers">
					<tr><th>Balance</th></tr>
					<tr><td><c:out value="${balance}"></c:out></td>
				</table>
			</c:if>
			
			<c:if test="${op=='delete_account'}">
				<h1><c:out value="Sucessfully Account deleted"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='display_all_detailes'}">
				<table id="customers">
					<tr>
						<th>Account Number</th>
						<th>Name</th>
						<th>Balance</th>
					</tr>
					<c:forEach var="cus" items="${list}">
						<tr>
							<td><c:out value="${cus.getAccno()}"></c:out></td>
							<td><c:out value="${cus.getName()}"></c:out></td>
							<td><c:out value="${cus.getBalance()}"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			
			
		</article>
	</section>
</body>
</html>