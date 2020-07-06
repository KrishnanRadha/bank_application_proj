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
			<jsp:include page="user_operation.jsp"></jsp:include>
		</nav>
		<article>
			<c:if test="${op=='deposit'}">
				<h1><c:out value="${balance}"></c:out><c:out value=" - Sucessfully deposited!!!"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='set_pin'}">
				<h1><c:out value="Sucessfully pin setted!!!"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='withdraw'}">
				<h1><c:out value="${balance}"></c:out><c:out value=" - Sucessfully withdrawn!!!"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='transfer_money'}">
				<h1><c:out value="${balance}"></c:out><c:out value=" - Sucessfully Transfered!!!"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='transaction_detailes'}">
				<table id="customers">
					<tr>
						<th>Account Number</th>
						<th>Type of transaction</th>
						<th>Transfered balance Balance</th>
					</tr>
					<c:forEach var="t" items="${list}">
						<tr>
							<td><c:out value="${t.getAccno()}"></c:out></td>
							<td><c:out value="${t.getTyOfTran()}"></c:out></td>
							<td><c:out value="${t.getBalance()}"></c:out></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			
			<c:if test="${op=='change_password'}">
				<h1><c:out value="Sucessfully Password changed!!!"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='check_balance'}">
				<table id="customers">
					<tr><th>Balance</th></tr>
					<tr><td><c:out value="${balance}"></c:out></td>
				</table>
			</c:if>
			
		</article>
	</section>
</body>
</html>