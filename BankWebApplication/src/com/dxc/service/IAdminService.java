package com.dxc.service;

import java.util.List;

import com.dxc.pojo.Customer;

public interface IAdminService {

	boolean authendicationAdmin(String name, String password);

	boolean addCoustomer(int accno, String name, String password);

	Customer searchAccountDetailes(int accno);

	boolean modifyCoustomer(int accno, String name, String password,double balance);

	double balanceInquiry(int accno);

	boolean deleteAccount(int accno);

	List<Customer> getAllAccountDetailes();

}
