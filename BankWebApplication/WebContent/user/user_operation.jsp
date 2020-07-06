<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Operation</title>
</head>
<link rel="stylesheet" type="text/css" href="css/menu.css"> 
<link rel="stylesheet" type="text/css" href="css/layout.css">
<link rel="stylesheet" type="text/css" href="css/formdesign.css">
<body bgcolor="cyan">
		
			<div class="tab">
				<a href="deposit.jsp"><button>Deposit</button></a>
				<a href="withdraw.jsp"><button>Withdraw </button></a>
				<a href="transfer_money.jsp"><button>Transfer money</button></a>
				<a href="check_balance.jsp"><button>Check account balance</button></a>
				<a href="set_pin.jsp"><button>Set/Update 4 digit pin</button></a>
				
				<form action="user">
				<button type="submit" name="op" value="transaction_detailes">transaction details</button>
				</form>
				
				<a href="change_password.jsp"><button>Change password</button></a>
				<a href="http://localhost:8080/BankWebApplication/"><button>logout</button></a>
			</div>
		
</body>
</html>