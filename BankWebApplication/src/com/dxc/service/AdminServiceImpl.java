package com.dxc.service;

import java.util.List;

import com.dxc.dao.*;
import com.dxc.pojo.Customer;

public class AdminServiceImpl implements IAdminService{
	
	IAdminDao ids=new AdminDaoImpl();
	
	@Override
	public boolean authendicationAdmin(String name, String password) {
		return ids.authendicationAdmin(name,password);
	}

	@Override
	public boolean addCoustomer(int accno, String name, String password) {
		return ids.addCoustomer(accno,name,password);
	}

	@Override
	public Customer searchAccountDetailes(int accno) {
		return ids.searchAccountDetailes(accno);
	}

	@Override
	public boolean modifyCoustomer(int accno, String name, String password,double balance) {
		return ids.modifyCoustomer(accno,name,password,balance);
	}

	@Override
	public double balanceInquiry(int accno) {
		return ids.balanceInquiry(accno);
	}

	@Override
	public boolean deleteAccount(int accno) {
		return ids.deleteAccount(accno);
	}

	@Override
	public List<Customer> getAllAccountDetailes() {
		return ids.getAllAccountDetailes();
	}

}
