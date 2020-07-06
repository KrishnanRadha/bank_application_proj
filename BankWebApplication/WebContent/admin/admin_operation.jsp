<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin operation</title>
</head>
<link rel="stylesheet" type="text/css" href="css/menu.css"> 
<link rel="stylesheet" type="text/css" href="css/layout.css">
<link rel="stylesheet" type="text/css" href="css/formdesign.css">
<body bgcolor="cyan">
		
			<div class="tab">
				<a href="create_new_account.jsp"><button>Create/add a new customer account </button></a>
				<a href="search_particular_detailes.jsp"><button>Search the Customer Details by account number</button></a>
				<a href="modify_customer_detailes.jsp"><button>Modify the Customer Details by account number </button></a>
				<a href="balance_inquiry.jsp"><button>Balance inquiry for a particular account</button></a>
				<a href="delete_account_from_bank.jsp"><button>Delete the Customer Account from Banks System.</button></a>
				<form action="admin">
				<button type="submit" name="op" value="display_all_detailes">Display all customer details</button>
				</form>
				<a href="http://localhost:8080/BankWebApplication/"><button>logout</button></a>
			</div>
		
</body>
</html>