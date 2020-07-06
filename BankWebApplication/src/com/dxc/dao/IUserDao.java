package com.dxc.dao;

import java.util.List;

import com.dxc.pojo.Transection;

public interface IUserDao {

	int getAccno(String name, String password);

	boolean authendicateUser(String name, String password);

	boolean setPin(int accno, int pin);

	boolean deposit(int accno,  double balance);

	boolean withdraw(int accno, double balance);

	boolean checkPin(int accno, int pin);

	boolean checkAccountNo(int tAcc);

	boolean transfer(int accno, int tAcc, double balance);

	double getBalance(int accno);

	List<Transection> getTransectionDetailes(int accno);

	boolean checkOldPass(int accno, String oldPassword);

	boolean changePassword(int accno, String newPassword);
	


}
