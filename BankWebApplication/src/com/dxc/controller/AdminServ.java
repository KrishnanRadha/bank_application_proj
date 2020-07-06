package com.dxc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pojo.Customer;
import com.dxc.service.*;
@WebServlet("/admin/admin")
public class AdminServ extends HttpServlet{
	
	IAdminService ias=new AdminServiceImpl();
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		String op=request.getParameter("op");
		
		if(op.equals("Admin_Login"))
		{
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			boolean b=ias.authendicationAdmin(name,password);
			if(b==true)
			{
					response.sendRedirect("http://localhost:8080/BankWebApplication/admin/admin_operation.jsp");
					
			}else
			{
					response.getWriter().println("name & password incorrect!!!");
			}
		}else if(op.equals("Add_Account"))
		{
			int accno=Integer.parseInt(request.getParameter("acNo")); 
			String name1=request.getParameter("name");
			String password1=request.getParameter("password");
			boolean b=ias.addCoustomer(accno,name1,password1);
			if(b==true)
			{
				session.setAttribute("op", op);
				response.sendRedirect("http://localhost:8080/BankWebApplication/admin/admin_view.jsp");
					
			}
		}else if(op.equals("search_account_detailes"))
		{
			int accno=Integer.parseInt(request.getParameter("acNo")); 
			Customer c=ias.searchAccountDetailes(accno);
			session.setAttribute("op", op);
			session.setAttribute("c", c);
			response.sendRedirect("http://localhost:8080/BankWebApplication/admin/admin_view.jsp");
		}else if(op.equals("modify_custemar_detailes"))
		{
			int accno=Integer.parseInt(request.getParameter("acNo")); 
			String name1=request.getParameter("name");
			String password1=request.getParameter("password");
			double balance=Double.parseDouble(request.getParameter("balance"));
			boolean b=ias.modifyCoustomer(accno,name1,password1,balance);
			if(b==true)
			{
				session.setAttribute("op", op);
				response.sendRedirect("http://localhost:8080/BankWebApplication/admin/admin_view.jsp");
					
			}
		}else if(op.equals("balance_inquiry"))
		{
			int accno=Integer.parseInt(request.getParameter("acNo")); 
			double balance=ias.balanceInquiry(accno);
			session.setAttribute("op", op);
			session.setAttribute("balance", balance);
			response.sendRedirect("http://localhost:8080/BankWebApplication/admin/admin_view.jsp");
		}else if(op.equals("delete_account"))
		{
			int accno=Integer.parseInt(request.getParameter("acNo")); 
			boolean b=ias.deleteAccount(accno);
			if(b==true)
			{
				session.setAttribute("op", op);
				response.sendRedirect("http://localhost:8080/BankWebApplication/admin/admin_view.jsp");
					
			}
		}else if(op.equals("display_all_detailes"))
		{
			List<Customer> lst=ias.getAllAccountDetailes();
			session.setAttribute("op", op);
			session.setAttribute("list", lst);
			response.sendRedirect("http://localhost:8080/BankWebApplication/admin/admin_view.jsp");
		}
		
	}

}

