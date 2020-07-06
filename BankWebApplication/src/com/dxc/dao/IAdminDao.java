package com.dxc.dao;

import java.util.List;

import com.dxc.pojo.Customer;

public interface IAdminDao {

	boolean authendicationAdmin(String name, String password);

	boolean addCoustomer(int accno, String name, String password);

	Customer searchAccountDetailes(int accno);

	boolean modifyCoustomer(int accno, String name, String password,double balance);

	double balanceInquiry(int accno);

	boolean deleteAccount(int accno);

	List<Customer> getAllAccountDetailes();
	


}
