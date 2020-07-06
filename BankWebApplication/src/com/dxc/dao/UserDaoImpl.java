package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojo.Transection;

public class UserDaoImpl implements IUserDao{
	
	private static Connection conn=null;
	static {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application","root","Krish@1001");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
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
	public int getAccno(String name, String password) {
		int accno=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement("select accno from customer where name=? && password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			accno=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accno;
	}


	@Override
	public boolean authendicateUser(String name, String password) {
		boolean b=false;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from customer");
			while(rs.next())
			{
				if(name.equals(rs.getString(2)) && password.equals(rs.getString(3)))
				{
					b=true;
				}


			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public boolean setPin(int accno, int pin) {
		boolean b=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement("update customer set pin=? where accno=?");
			pstmt.setInt(1, pin);
			pstmt.setInt(2, accno);
			pstmt.executeUpdate();
			pstmt.close();
			b=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}


	@Override
	public boolean deposit(int accno, double balance) {
		boolean b=false;
		double bal=0;
		try {
			
			PreparedStatement pstmt = conn.prepareStatement("select balance from customer where accno=?");
			pstmt.setInt(1,accno);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			bal=rs.getDouble(1);
			pstmt.close();
			
			bal=bal+balance;
			
			PreparedStatement pstmt1=conn.prepareStatement("update customer set balance=? where accno=?");
			pstmt1.setDouble(1, bal);
			pstmt1.setInt(2, accno);
			pstmt1.executeUpdate();
			pstmt1.close();
			PreparedStatement pstmt3=conn.prepareStatement("insert into transaction_detailes values(?,?,?)");
			pstmt3.setInt(1, accno);
			pstmt3.setString(2, "deposit");
			pstmt3.setDouble(3, balance);
			pstmt3.executeUpdate();
			pstmt3.close();
			
			b=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	@Override
	public boolean withdraw(int accno, double balance) {
		
		boolean b=false;
		double bal=0;
		try {
			if(balance>this.getBalance(accno))
			{
				return false;
			}
			PreparedStatement pstmt = conn.prepareStatement("select balance from customer where accno=?");
			pstmt.setInt(1,accno);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			bal=rs.getDouble(1);
			pstmt.close();
			
			bal=bal-balance;
			
			PreparedStatement pstmt1=conn.prepareStatement("update customer set balance=? where accno=?");
			pstmt1.setDouble(1, bal);
			pstmt1.setInt(2, accno);
			pstmt1.executeUpdate();
			pstmt1.close();
			
			PreparedStatement pstmt3=conn.prepareStatement("insert into transaction_detailes values(?,?,?)");
			pstmt3.setInt(1, accno);
			pstmt3.setString(2, "withdraw");
			pstmt3.setDouble(3, balance);
			pstmt3.executeUpdate();
			pstmt3.close();
			
			b=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}


	@Override
	public boolean checkPin(int accno, int pin) {
		boolean b=false;
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM customer WHERE accno=? && pin=?");
			pstmt.setInt(1, accno);
			pstmt.setInt(2, pin);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(accno==rs.getInt(1) && pin==rs.getInt(5))
				{
					b=true;
				}
			}
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public boolean checkAccountNo(int tAcc) {
		boolean b=false;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select accno from customer");
			while(rs.next())
			{
				if(tAcc==rs.getInt(1))
				{
					b=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}


	@Override
	public boolean transfer(int accno, int tAcc, double balance) {
		if(balance>this.getBalance(accno))
		{
			return false;
		}
		
		double cbal=0,tbal=0;
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("select * from customer");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(accno==rs.getInt(1))
				{
					cbal=rs.getDouble(4);
				}else if(tAcc==rs.getInt(1))
				{
					tbal=rs.getDouble(4);
				}
			}
			pstmt.close();
			if(cbal<balance)
			{
				return false;
			}
			cbal=cbal-balance;
			tbal=tbal+balance;
			
			PreparedStatement pstmt1=conn.prepareStatement("update customer set balance=? where accno=?");
			pstmt1.setDouble(1, cbal);
			pstmt1.setInt(2, accno);
			pstmt1.executeUpdate();
			pstmt1.close();
			
			PreparedStatement pstmt2=conn.prepareStatement("update customer set balance=? where accno=?");
			pstmt2.setDouble(1, tbal);
			pstmt2.setInt(2, tAcc);
			pstmt2.executeUpdate();
			pstmt2.close();
			
			PreparedStatement pstmt3=conn.prepareStatement("insert into transaction_detailes values(?,?,?)");
			pstmt3.setInt(1, accno);
			pstmt3.setString(2, "Transfer");
			pstmt3.setDouble(3, balance);
			pstmt3.executeUpdate();
			pstmt3.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public double getBalance(int accno) {
		double balance=0;
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("select balance from customer where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			balance=rs.getDouble(1);
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}


	@Override
	public List<Transection> getTransectionDetailes(int accno) {
		List<Transection> list =new ArrayList<Transection>();
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from transaction_detailes where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				list.add(new Transection(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return list;
	}


	@Override
	public boolean checkOldPass(int accno, String oldPassword) {
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select password from customer where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(oldPassword.equals(rs.getString(1)))
				{
					return true;
				}
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean changePassword(int accno, String newPassword) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("update customer set password=? where accno=?");
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, accno);
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}