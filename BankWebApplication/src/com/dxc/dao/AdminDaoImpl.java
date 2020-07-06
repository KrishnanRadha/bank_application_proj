package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojo.Customer;

public class AdminDaoImpl implements IAdminDao{
	private static Connection conn=null;
	static {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application","root","Krish@1001");
			System.out.println("class loaded & registered");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean authendicationAdmin(String name, String password) {
		boolean b=false;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select name,password from admin");
			while(rs.next())
			{
				if(name.equals(rs.getString(1)) && password.equals(rs.getString(2)))
				{
					b= true;
				}
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
	@Override
	public boolean addCoustomer(int accno, String name, String password) {
		boolean b=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into customer values(?,?,?,?,?)");
			pstmt.setInt(1, accno);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setDouble(4, 0);
			pstmt.setInt(5, 0);
			pstmt.executeUpdate();
			pstmt.close();
			b=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	
	public void closeConnection()
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public Customer searchAccountDetailes(int accno) {
		PreparedStatement pstmt;
		Customer c=null;
		try {
			pstmt = conn.prepareStatement("select * from customer where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			c=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}


	@Override
	public boolean modifyCoustomer(int accno, String name, String password,double balance) {
		boolean b=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("update customer set name=?,password=?,balance=? where accno=?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setDouble(3, balance);
			pstmt.setInt(4, accno);
			pstmt.executeUpdate();
			pstmt.close();
			b=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public double balanceInquiry(int accno) {
		double balance=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select balance from customer where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			balance=rs.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}


	@Override
	public boolean deleteAccount(int accno) {
		boolean b=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("delete from customer where accno=?");
			pstmt.setInt(1, accno);
			pstmt.execute();
			pstmt.close();
			b=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public List<Customer> getAllAccountDetailes() {
		List<Customer> list=new ArrayList<Customer>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from customer");
			while(rs.next())
			{
				list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
