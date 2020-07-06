package com.dxc.pojo;

public class Customer {
	
	private int accno;
	private String name;
	private String password;
	private Double balance;
	private int pin;
	
	public Customer() {
	}

	public Customer(int accno, String name, String password, Double balance, int pin) {
		this.accno = accno;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.pin = pin;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return accno+" "+name+" "+balance;
	}
	
	
	
	
}
