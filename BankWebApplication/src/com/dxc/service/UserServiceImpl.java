package com.dxc.service;

import java.sql.PreparedStatement;
import java.util.List;

import com.dxc.dao.IUserDao;
import com.dxc.dao.UserDaoImpl;
import com.dxc.pojo.Transection;

public class UserServiceImpl implements IUserService {

	IUserDao iud=new UserDaoImpl();
	@Override
	public int getAccno(String name,String password) {
		return iud.getAccno(name,password);
	}
	@Override
	public boolean authendicateUser(String name, String password) {
		return iud.authendicateUser(name,password);
	}
	@Override
	public boolean setPin(int accno, int pin) {
		return iud.setPin(accno,pin);
	}
	@Override
	public boolean deposit(int accno, double balance) {
		return iud.deposit(accno,balance);
	}
	@Override
	public boolean withdraw(int accno, double balance) {
		return iud.withdraw(accno, balance);
	}
	@Override
	public boolean checkPin(int accno, int pin) {
		return iud.checkPin(accno,pin);
	}
	@Override
	public boolean checkAccountNo(int tAcc) {
		return iud.checkAccountNo(tAcc);
	}
	@Override
	public boolean transfer(int accno, int tAcc, double balance) {
		return iud.transfer(accno,tAcc,balance);
	}
	@Override
	public double getBalance(int accno) {
		return iud.getBalance(accno);
	}
	@Override
	public List<Transection> getTransectionDetailes(int accno) {
		return iud.getTransectionDetailes(accno);
	}
	@Override
	public boolean checkOldPass(int accno, String oldPassword) {
		return iud.checkOldPass(accno,oldPassword);
	}
	@Override
	public boolean changePassword(int accno, String newPassword) {
		return iud.changePassword(accno,newPassword);
	}

}
