package com.dxc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojo.Transection;
import com.dxc.service.IUserService;
import com.dxc.service.UserServiceImpl;

@WebServlet("/user/user")
public class UserServ extends HttpServlet {
	
	private int accno;
	
	IUserService ius=new UserServiceImpl();
	
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		String op=request.getParameter("op");
		
		if(op.equals("User_Login"))
		{
			
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			accno=ius.getAccno(name,password);
			boolean b=ius.authendicateUser(name,password);
			if(b==true)
			{
				response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_operation.jsp");
				
			}else{response.getWriter().println("name & password incorrect!!!");}
			
			
		}else if(op.equals("set_pin"))
		{
			
			if(request.getParameter("pin").length()==4)
			{
				int pin=Integer.parseInt(request.getParameter("pin"));
				boolean b=ius.setPin(accno,pin);
				if(b==true)
				{
					session.setAttribute("op", op);
					response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_view.jsp");
					
				}else{response.getWriter().println("Somthing Wrong!!!");}
			}else{response.getWriter().println("Pin must be 4 digit");}
			
			
		}else if(op.equals("deposit"))
		{
			
			int accno1=Integer.parseInt(request.getParameter("accno"));
			boolean b1=ius.checkAccountNo(accno1);
			if(b1==true)
			{
				double balance=Double.parseDouble(request.getParameter("balance"));
				boolean b=ius.deposit(accno1,balance);
				if(b==true)
				{
					session.setAttribute("op", op);
					session.setAttribute("balance", balance);
					response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_view.jsp");
					
				}else{response.getWriter().println("Somethink Wrong!!!");}
			}else{response.getWriter().println("Particular Account No is not find!!!..");}
			
			
		}else if(op.equals("withdraw"))
		{
			
			
			int pin=Integer.parseInt(request.getParameter("pin"));
			boolean b1=ius.checkPin(accno,pin);
			
			
			if(b1==true)
			{
				double balance=Double.parseDouble(request.getParameter("balance"));
				boolean b=ius.withdraw(accno,balance);
				if(b==true)
				{
					session.setAttribute("op", op);
					session.setAttribute("balance", balance);
					response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_view.jsp");
					
				}else{response.getWriter().println("In sufficiant balance!!!");}
			}else{response.getWriter().println("Pin is Wrong/you have to set pin!!!");}
			
			
		}else if(op.equals("transfer_money"))
		{
			
			
			int pin=Integer.parseInt(request.getParameter("pin"));
			int tAcc=Integer.parseInt(request.getParameter("tAcno"));
			double balance=Double.parseDouble(request.getParameter("balance"));
			
			boolean b1=ius.checkPin(accno,pin);
			if(b1==true)
			{
				boolean b2=ius.checkAccountNo(tAcc);
				if(b2==true)
				{
					boolean b=ius.transfer(accno,tAcc,balance);
					if(b==true)
					{
						session.setAttribute("op", op);
						session.setAttribute("balance", balance);
						response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_view.jsp");
						
					}else{response.getWriter().println("In sufficiant balance!!!");}
				}else{response.getWriter().println("Target account is not available in bank");}
			}else{response.getWriter().println("Pin is Wrong/you have to set pin!!!");}
				
		}else if(op.equals("check_balance"))
		{
			
			
			int pin=Integer.parseInt(request.getParameter("pin"));
			boolean b1=ius.checkPin(accno,pin);
			if(b1==true)
			{
				double balance=ius.getBalance(accno);
				session.setAttribute("op", op);
				session.setAttribute("balance", balance);
				response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_view.jsp");
			}else{response.getWriter().println("Pin is Wrong/you have to setpin!!!");}
			
			
		}else if(op.equals("transaction_detailes"))
		{
			
			List<Transection> lst=new ArrayList<Transection>();
				lst=ius.getTransectionDetailes(accno);
				session.setAttribute("op", op);
				session.setAttribute("list", lst);
				response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_view.jsp");
				
		}else if(op.equals("change_password"))
		{
				String oldPassword=request.getParameter("oldPass");
				String newPassword=request.getParameter("newPass");
				boolean b=ius.checkOldPass(accno,oldPassword);
				if(b==true)
				{
					boolean b1=ius.changePassword(accno,newPassword);
					if(b1==true) 
					{
						session.setAttribute("op", op);
						response.sendRedirect("http://localhost:8080/BankWebApplication/user/user_view.jsp");
					}else {response.getWriter().println("somhting wrong in change password!!!");}
				}else{response.getWriter().println("Old password is wrong!!!");}
		}
		
		
		
	}
}

